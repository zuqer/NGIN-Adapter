package thm.regvm.tukejai.adapter;

import java.io.File;
import java.util.List;

import thm.regvm.tukejai.info.XAdapterDataImportInfo;

public class NGINAdapter implements Adapter {
	
	private static Adapter instance ;
	private static String folderPath ;
	
	public static Adapter getInstance(){
		if(instance == null){
			instance = new NGINAdapter();
		}
		return instance;
	}

	public boolean valiadateExistFile(String path) {
		File file = new File(path);
		if(file.exists()){
			folderPath = path;
		}
		return file.exists();
	}

	public List<XAdapterDataImportInfo> listItemInfile() throws AdapterException {
		if(folderPath ==null){
			throw new AdapterException("Invalid path");
		}
		return null;
	}

	public void createCSVFile(String string, String[] fieldArray) {
		// TODO Auto-generated method stub
		
	}



}
