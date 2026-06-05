package cn.easydat.ai;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.easydat.ai.entity.Req;
import cn.easydat.ai.entity.ReqMsg;
import cn.hutool.core.io.FileUtil;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSource;
import tools.jackson.databind.ObjectMapper;

public class Test {

	private static final String DEFAULT_MODEL = "DeepSeek-V4-Flash";

	public static void main(String[] args) {
		List<ReqMsg> messages = new ArrayList<>();
		messages.add(new ReqMsg("user", "你能做什么"));
		Test test = new Test();
		test.test(messages);
	}

	public void test(List<ReqMsg> messages) {
		String prompt = buildPrompt(messages);
		System.out.println("prompt:" + prompt);
		String API_URL = "https://ark.cn-beijing.volces.com/api/coding/v3/chat/completions";
		String API_KEY = "ef5986b3-0aa6-4395-b745-abba09a649eb";

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(API_URL).addHeader("Authorization", "Bearer " + API_KEY)
				.addHeader("Accept", "text/event-stream").addHeader("Content-Type", "application/json")
				.post(RequestBody.create(prompt, MediaType.parse("application/json"))).build();

		List<String> list = new ArrayList<>();
		
		try (Response response = client.newCall(request).execute()){
			BufferedSource source = response.body().source();
			
			while (!source.exhausted()) {
				
				String line = source.readUtf8Line();
				list.add(line);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileUtil.writeLines(list, Test.class.getResource("").getPath()+"/ai.log", "utf-8");


	}

	private String buildPrompt(List<ReqMsg> messages) {
		Req req = new Req(DEFAULT_MODEL, messages);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(req);
	}

}
