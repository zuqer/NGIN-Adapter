package thm.regvm.tukejai.adapter;

import java.util.List;

import thm.regvm.tukejai.info.XAdapterDataImportInfo;

public class NGINAdapter implements Adapter {
	
	private static Adapter instance ;
	
	public static Adapter getInstance(){
		if(instance == null){
			instance = new NGINAdapter();
		}
		return instance;
	}

	public boolean valiadateExistFile(String path) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<XAdapterDataImportInfo> listItemInfile() {
		// TODO Auto-generated method stub
		return null;
	}

	public void createCSVFile(String string, String[] fieldArray) {
		// TODO Auto-generated method stub
		
	}



}
