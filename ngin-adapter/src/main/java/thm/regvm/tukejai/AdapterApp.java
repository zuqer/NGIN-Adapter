package thm.regvm.tukejai;

import java.util.List;

import thm.regvm.tukejai.adapter.Adapter;
import thm.regvm.tukejai.adapter.AdapterException;
import thm.regvm.tukejai.adapter.NGINAdapter;
import thm.regvm.tukejai.info.XAapterDataField;
import thm.regvm.tukejai.info.XAdapterDataImportInfo;

public class AdapterApp {

	public static void main(String[] args) {
		Adapter adapter = NGINAdapter.getInstance();
		if (adapter.valiadateExistFile("")) {
			try {
				List<XAdapterDataImportInfo> itemlist = adapter.listItemInfile("");
				adapter.createCSVFile("", XAapterDataField.fieldArray);
			} catch (AdapterException e) {
				e.printStackTrace();
			}

		}

	}

}
