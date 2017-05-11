package thm.regvm.tukejai.adapter;

import java.util.List;

import thm.regvm.tukejai.info.XAdapterDataImportInfo;

public interface Adapter {

	boolean valiadateExistFile(String path);

	List<XAdapterDataImportInfo> listItemInfile(String path) throws AdapterException;

	void createCSVFile(String string, String[] fieldArray);

}
