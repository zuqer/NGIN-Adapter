package thm.regvm.tukejai;

import junit.framework.TestCase;
import thm.regvm.tukejai.adapter.Adapter;
import thm.regvm.tukejai.adapter.NGINAdapter;
import thm.regvm.tukejai.info.XAdapterDataImportInfo;

public class NGINPraseHtmlTest extends TestCase {

	public void testPraseHtml() {
		Adapter adapter = NGINAdapter.getInstance();
		String requestPath = "F:/Regvm Project/game.tukejai.com/selectFile/product-detailbb33.html" ;
		//String requestPath = "F:/Regvm Project/game.tukejai.com/contentDL/NGIN/NGIN/www.ngin.co.th/product-detail0d7d.html" ;
		XAdapterDataImportInfo info = adapter.phaseModel(requestPath);
		assertNotNull(info);
		System.out.println("request info "+info.getPostContent());
		
		
	}

}
