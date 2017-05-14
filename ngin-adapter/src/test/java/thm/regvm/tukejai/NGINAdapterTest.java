package thm.regvm.tukejai;

import java.io.IOException;

import junit.framework.TestCase;
import thm.regvm.tukejai.adapter.Adapter;
import thm.regvm.tukejai.adapter.AdapterException;
import thm.regvm.tukejai.adapter.NGINAdapter;
import thm.regvm.tukejai.info.XAapterDataField;

/**
 * Unit test for simple App.
 */
public class NGINAdapterTest extends TestCase {


	/**
	 * Rigourous Test :-)
	 */
	public void testInstanceExcute() {
		Adapter adapter = NGINAdapter.getInstance();
		assertNotNull(adapter);
	}

	public void testValidExistFile() {
		Adapter adapter = NGINAdapter.getInstance();
		String fakepath = "F:/Regvm Project/game.tukejai.com/contentDL/NGIN/NGIN/www.ngin.co.th/s";
		assertEquals(false, adapter.valiadateExistFile(fakepath));
		String truepath = "F:/Regvm Project/game.tukejai.com/contentDL/NGIN/NGIN/www.ngin.co.th/";
		assertEquals(true, adapter.valiadateExistFile(truepath));
	}

	public void testListWithInvalidpath() {
		Adapter adapter = NGINAdapter.getInstance();
		String fakepath = "F:/Regvm Project/game.tukejai.com/contentDL/NGIN/NGIN/www.ngin.co.th/s";
		adapter.valiadateExistFile(fakepath);
		try {
			adapter.listItemInfile(fakepath);
			assertFalse(true);

		} catch (AdapterException e) {
			e.printStackTrace();
			assertEquals(true, true);
		}
		String truepath = "F:/Regvm Project/game.tukejai.com/contentDL/NGIN/NGIN";
		adapter.valiadateExistFile(truepath);
		try {
			adapter.listItemInfile(truepath);
			assertEquals(true, true);
		} catch (AdapterException e) {
			e.printStackTrace();
			assertFalse(true);
		}

	}
	
	public void testGenerateOutput(){
		Adapter adapter = NGINAdapter.getInstance();
		try {
			adapter.createCSVFile("F:/Regvm Project/game.tukejai.com/File","F:/Regvm Project/game.tukejai.com/Import file/beta_generate_woocommerce-product-export.csv", XAapterDataField.fieldArray,null);
		} catch (AdapterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
