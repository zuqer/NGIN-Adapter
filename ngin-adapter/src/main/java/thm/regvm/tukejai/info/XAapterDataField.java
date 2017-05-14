package thm.regvm.tukejai.info;

public class XAapterDataField {

	public static String XPATH_POST_TITLE = "/html/body/div[3]/div/div[1]/text()";
	@Deprecated
	public static String XPATH_POST_EXCERPT = "";
	//public static String XPATH_POST_CONTENT_LIST = "/html/body/div[3]/div/ul/li[2]/div/p/text()";
	public static String XPATH_POST_CONTENT_LIST = "/html/body/div[3]/div/ul/li[2]/div/div/text()";
	public static String XPATH_YOU_TUBE = "/html/body/div[3]/div/ul/li[2]/div/iframe";
	public static String XPATH_IMG_THUM = "/html/body/div[3]/div/ul/li[1]/div/img";
	public static String XPATH_PLATFORM = "/html/body/div[3]/div/ul/li[1]/div/p[1]/span[2]/text()";
	public static String XPATH_GENRE = "/html/body/div[3]/div/ul/li[1]/div/p[2]/span[2]/text()";
	public static String XPATH_RELEASE_DATE = "/html/body/div[3]/div/ul/li[1]/div/p[3]/span[2]/text()";
	public static String XPATH_PUBLISHER = "/html/body/div[3]/div/ul/li[1]/div/p[4]/span[2]/text()";
	public static String XPATH_AGE = "/html/body/div[3]/div/ul/li[1]/div/p[6]/span[2]/text()";
	public static String XPATH_NARRATION = "/html/body/div[3]/div/ul/li[1]/div/p[7]/span[2]/text()";
	public static String XPATH_SUB_TITLE = "/html/body/div[3]/div/ul/li[1]/div/p[8]/span[2]/text()";
	public static String XPATH_MEDIA = "/html/body/div[3]/div/ul/li[1]/div/p[9]/span[2]/text()";

	public static String[] fieldArray = { "post_title", "post_name", "ID", "post_excerpt", "post_content", "post_status", "menu_order", "post_date", "post_author", "comment_status", "sku",
			"downloadable", "virtual", "stock", "regular_price", "sale_price", "weight", "length", "width", "height", "tax_class", "visibility", "stock_status", "backorders", "manage_stock",
			"tax_status", "upsell_ids", "crosssell_ids", "featured", "sale_price_dates_from", "sale_price_dates_to", "download_limit", "download_expiry", "product_url", "button_text", "images",
			"downloadable_files", "tax:manufacturer", "tax:product_type", "tax:product_visibility", "tax:product_cat", "tax:product_tag", "tax:product_shipping_class" };

}
