package thm.regvm.tukejai.adapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.w3c.dom.NodeList;

import thm.regvm.tukejai.info.XAapterDataField;
import thm.regvm.tukejai.info.XAdapterDataImportInfo;
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

	public List<XAdapterDataImportInfo> listItemInfile(String folderpath) throws AdapterException {
		System.out.println("folder path " + folderpath);
		if (!valiadateExistFile(folderpath)) {
			throw new AdapterException("Invalid path");
		}
		return null;
	}

	public void createCSVFile(String htmlOriginPath, String[] fieldArray) throws AdapterException {
		System.out.println("Read file at " + htmlOriginPath);
		if (!valiadateExistFile(htmlOriginPath)) {
			throw new AdapterException("Invalid htmlOriginPath");
		}

	}

	public XAdapterDataImportInfo phaseModel(String filePath) {
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
		// TODO Auto-generated method stub
		return null;
	}

	private StringBuilder getDetailTemplate(Document doc) throws XPathExpressionException {
		final StringBuilder detailInfo = new StringBuilder();
		XPathFactory xPathfactory = XPathFactory.newInstance();
		XPath xpath = xPathfactory.newXPath();
		List<String> valuelist = Xsoup.compile(XAapterDataField.XPATH_POST_CONTENT_LIST).evaluate(doc).list();
		valuelist.forEach( e->{
			detailInfo.append(e);
		});
		
		return detailInfo;
	}

}
