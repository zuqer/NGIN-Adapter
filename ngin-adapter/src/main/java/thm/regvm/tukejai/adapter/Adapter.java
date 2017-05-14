package thm.regvm.tukejai.adapter;

import java.io.IOException;
import java.util.List;

import thm.regvm.tukejai.info.XAdapterDataImportInfo;

public interface Adapter {

	boolean valiadateExistFile(String path);

	List<XAdapterDataImportInfo> listItemInfile(String folderpath) throws AdapterException;
	
	XAdapterDataImportInfo phaseModel(String filePath);

	void createCSVFile(String sourcePath,String outputPath, String[] fieldArray,List<XAdapterDataImportInfo> listInfo) throws AdapterException, IOException;

}
