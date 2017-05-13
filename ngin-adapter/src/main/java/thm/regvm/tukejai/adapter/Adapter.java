package thm.regvm.tukejai.adapter;

import java.util.List;

import thm.regvm.tukejai.info.XAdapterDataImportInfo;

public interface Adapter {

	boolean valiadateExistFile(String path);

	List<XAdapterDataImportInfo> listItemInfile(String folderpath) throws AdapterException;
	
	XAdapterDataImportInfo phaseModel(String filePath);

	void createCSVFile(String outputPath, String[] fieldArray) throws AdapterException;

}
