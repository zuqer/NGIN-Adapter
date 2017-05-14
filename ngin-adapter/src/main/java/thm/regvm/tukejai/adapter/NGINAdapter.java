package thm.regvm.tukejai.adapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.opencsv.CSVWriter;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.ColumnPositionMappingStrategy;

import thm.regvm.tukejai.info.XAapterDataField;
import thm.regvm.tukejai.info.XAdapterDataImportInfo;
import us.codecraft.xsoup.XElements;
import us.codecraft.xsoup.Xsoup;

public class NGINAdapter implements Adapter {

	private static Adapter instance;

	public synchronized static Adapter getInstance() {
		if (instance == null) {
			synchronized (NGINAdapter.class) {
				if (instance == null) {
					instance = new NGINAdapter();
				}
			}

		}
		return instance;
	}

	public boolean valiadateExistFile(String path) {
		File file = new File(path);
		return file.exists();
	}

	public List<XAdapterDataImportInfo> listItemInfile(String path) throws AdapterException {
		List<XAdapterDataImportInfo> listData = new ArrayList<>();
		if (!valiadateExistFile(path)) {
			throw new AdapterException("Invalid path");
		}
		File folderPath = new File(path);
		for (final File fileEntry : folderPath.listFiles()) {
			XAdapterDataImportInfo info = phaseModel(fileEntry.getAbsolutePath());
			listData.add(info);
		}

		return listData;
	}

	public void createCSVFile(String sourcePath, String outputPath, String[] fieldArray, List<XAdapterDataImportInfo> listInfo) throws AdapterException, IOException {
		List<XAdapterDataImportInfo> dataInfoList = new ArrayList<>();

		if (!valiadateExistFile(sourcePath)) {
			throw new AdapterException("Invalid path");
		}
		if (CollectionUtils.isEmpty(listInfo)) {
			List<XAdapterDataImportInfo> listProduct = listItemInfile(sourcePath);
			dataInfoList.addAll(listProduct);
		} else {
			dataInfoList.addAll(listInfo);
		}
		final CSVWriter csvWriter = new CSVWriter(new FileWriter(outputPath));
		try {
			csvWriter.writeNext(XAapterDataField.fieldArray);

			dataInfoList.forEach(dImport -> {
				csvWriter.writeNext(dImport.toDefailtCSVString().split(","));
			});

		} finally {
			if (csvWriter != null) {
				try {
					csvWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public XAdapterDataImportInfo phaseModel(String filePath) {
		System.out.println("Path"+filePath);
		XAdapterDataImportInfo info = new XAdapterDataImportInfo();

		File input = new File(filePath);

		Document doc;
		try {
			doc = Jsoup.parse(input, "UTF-8");
			XPath xPath = XPathFactory.newInstance().newXPath();

			String gameName = Xsoup.compile(XAapterDataField.XPATH_POST_TITLE).evaluate(doc).get();
			info.setPostTitile(gameName);
			info.setPostName(CharecterUtil.replaceSpaceWithDash(gameName));
			StringBuilder gameFullDetail = getDetailTemplate(doc);
			info.setPostContent(gameFullDetail.toString());
			info.setPostStatus("publish");
			info.setPostDate(CharecterUtil.formateDate(new Date(), "MM/dd/yyyy hh:mm:ss a"));
			info.setPostAuthor("1");
			info.setCommentStatus("closed");
			info.setSku(StringUtils.EMPTY);
			info.setDownloadable("no");
			info.setVirtual("no");
			info.setStock("1");
			info.setRegularPrice("0");
			info.setSalePrice("0");
			info.setWeight(StringUtils.EMPTY);
			info.setLength(StringUtils.EMPTY);
			info.setWidth(StringUtils.EMPTY);
			info.setHeight(StringUtils.EMPTY);
			info.setTaxClass(StringUtils.EMPTY);
			info.setVisibility("visible");
			info.setStockStatus("instock");
			info.setBackorders("notify");
			info.setManageStock("yes");
			info.setTaxStatus("taxable");
			info.setUpsellIds(StringUtils.EMPTY);
			info.setCrosssellIds(StringUtils.EMPTY);
			info.setFeatured("no");
			info.setSalePriceDatesFrom(StringUtils.EMPTY);
			info.setSalePriceDatesTo(StringUtils.EMPTY);
			info.setDownloadLimit("-1");
			info.setDownloadExpiry("-1");
			info.setProductUrl(StringUtils.EMPTY);
			info.setButtonText(StringUtils.EMPTY);
			String urlURLGenerate = getImageFormat(doc);
			info.setImages(urlURLGenerate);
			info.setDownloadableFiles(StringUtils.EMPTY);
			info.setTaxManufacturer(StringUtils.EMPTY);
			info.setTaxProductType("simple");
			info.setTaxProductVisibility(StringUtils.EMPTY);
			String category= Xsoup.compile(XAapterDataField.XPATH_PLATFORM).evaluate(doc).get();
			info.setTaxProductCat(category);
			info.setTaxProductTag(StringUtils.EMPTY);
			info.setTaxProduct_shippingClass(StringUtils.EMPTY);	

		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return info;
	}

	private String getImageFormat(Document doc) {
		String contantValue = "http://game.tukejai.com/wp-content/uploads/2017/05";
		XElements imageName = Xsoup.compile(XAapterDataField.XPATH_IMG_THUM).evaluate(doc);

		String imageNameString = StringUtils.remove(imageName.getElements().attr("src"), "data/product/");

		StringBuffer imgURL = new StringBuffer();
		imgURL.append(contantValue);
		imgURL.append(imageNameString);

		return imgURL.toString();
	}

	private StringBuilder getDetailTemplate(Document doc) throws XPathExpressionException {
		final StringBuilder detailInfo = new StringBuilder();
//		XPathFactory xPathfactory = XPathFactory.newInstance();
//		XPath xpath = xPathfactory.newXPath();
//		List<String> valuelist = Xsoup.compile(XAapterDataField.XPATH_POST_CONTENT_LIST).evaluate(doc).list();
//		valuelist.forEach( e->{
//			detailInfo.append(StringUtils.replace(e, ",", StringUtils.EMPTY));
//		});
		
		return detailInfo;
	}


}
