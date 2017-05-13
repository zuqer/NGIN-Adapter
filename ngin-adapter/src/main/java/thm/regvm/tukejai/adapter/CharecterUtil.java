package thm.regvm.tukejai.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class CharecterUtil {
	
	public static String replaceSpaceWithDash(String originalString) {
		if (StringUtils.isEmpty(originalString)) {
			return "-";
		}
		StringBuffer newFillter = new StringBuffer();
		newFillter.append(StringUtils.replace(originalString, ":", StringUtils.EMPTY));
		return StringUtils.replace(newFillter.toString(), " ", "-");
	}
	
	public static String formateDate(Date requestDate, String templateDate) {
		String defaultPattern = "MM/dd/yyyy";
		if (templateDate != null) {
			defaultPattern = templateDate;
		}
		SimpleDateFormat format = new SimpleDateFormat(defaultPattern);

		return format.format(requestDate);

	}
	
	
}
