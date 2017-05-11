package thm.regvm.tukejai.adapter;

import java.io.File;
import java.util.List;

import thm.regvm.tukejai.info.XAdapterDataImportInfo;

public class NGINAdapter implements Adapter {
	
	private static Adapter instance ;
	
	public synchronized  static Adapter getInstance(){
		if(instance == null){
			synchronized (NGINAdapter.class) {
				if(instance ==null){
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
		System.out.println("folder path "+folderpath);
		if(!valiadateExistFile(folderpath)){
			throw new AdapterException("Invalid path");
		}
		return null;
	}

	public void createCSVFile(String string, String[] fieldArray) {
		// TODO Auto-generated method stub
		
	}



}
