package thm.regvm.tukejai;

import junit.framework.TestCase;
import thm.regvm.tukejai.adapter.Adapter;
import thm.regvm.tukejai.adapter.AdapterException;
import thm.regvm.tukejai.adapter.NGINAdapter;

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

}
