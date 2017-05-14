package thm.regvm.tukejai;

import java.io.IOException;
import java.util.List;

import thm.regvm.tukejai.adapter.Adapter;
import thm.regvm.tukejai.adapter.AdapterException;
import thm.regvm.tukejai.adapter.NGINAdapter;
import thm.regvm.tukejai.info.XAapterDataField;
import thm.regvm.tukejai.info.XAdapterDataImportInfo;

public class AdapterApp {

	public static void main(String[] args) {
		Adapter adapter = NGINAdapter.getInstance();
		if (adapter.valiadateExistFile("F:/Regvm Project/game.tukejai.com/File")) {
			try {
				List<XAdapterDataImportInfo> itemlist = adapter.listItemInfile("F:/Regvm Project/game.tukejai.com/File");
				adapter.createCSVFile("F:/Regvm Project/game.tukejai.com/File","F:/Regvm Project/game.tukejai.com/Import file/beta_generate_woocommerce-product-export.csv", XAapterDataField.fieldArray,null);
			} catch (AdapterException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("Done !!!");

	}

}
