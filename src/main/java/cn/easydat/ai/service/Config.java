package cn.easydat.ai.service;

public class Config {
	public static String API_KEY;
	public static String BASE_URL;

	static {
		API_KEY = System.getenv("VOLCENGINE_API_KEY");
		BASE_URL = System.getenv("VOLCENGINE_BASE_URL");
	}

}
