package cn.easydat.ai.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.easydat.ai.entity.ChatResponse;
import cn.easydat.ai.entity.Req;
import cn.easydat.ai.entity.ReqMsg;
import cn.easydat.ai.entity.Res;
import cn.easydat.ai.entity.ResChoiceDelta;
import cn.easydat.ai.entity.ResUsage;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSource;
import tools.jackson.databind.ObjectMapper;

public class AIService {

	private static final String API_URL = "https://ark.cn-beijing.volces.com/api/coding/v3/chat/completions";
	private static final String API_KEY = "ef5986b3-0aa6-4395-b745-abba09a649eb";
	private static final String DONE_SIGNAL = "[DONE]";
	private static final String DEFAULT_MODEL = "DeepSeek-V4-Flash";
	private static final String SEPARATOR = "--------------------";

	private ObjectMapper mapper = new ObjectMapper();

	public ChatResponse chat(List<ReqMsg> messages) {

		String prompt = buildPrompt(messages);
		ChatResponse chatResponse = null;

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(API_URL).addHeader("Authorization", "Bearer " + API_KEY)
				.addHeader("Accept", "text/event-stream").addHeader("Content-Type", "application/json")
				.post(RequestBody.create(prompt, MediaType.parse("application/json"))).build();

		try (Response response = client.newCall(request).execute()) {
			BufferedSource source = response.body().source();
			StringBuilder thinking = new StringBuilder();
			StringBuilder content = new StringBuilder();
			int cmd = 0;
			ResUsage resUsage = null;

			while (!source.exhausted()) {
				String line = source.readUtf8Line();
				if (line.startsWith("data: ")) {
					String json = line.substring(6);

					if (!DONE_SIGNAL.equals(json)) {
						Res res = mapper.readValue(json, Res.class);

						if (res.getChoices() != null && !res.getChoices().isEmpty()) {
							cmd = handleChoices(res, thinking, content, cmd);
						}

						if (null != res.getUsage()) {
							resUsage = res.getUsage();
						}
					} else {
						logContent("\n\n");
					}
				}
			}

			String thinkingStr = thinking.isEmpty() ? null : thinking.toString();
			String contentStr = content.isEmpty() ? null : content.toString();

			chatResponse = new ChatResponse(thinkingStr, contentStr, resUsage);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return chatResponse;
	}

	/**
	 * 0: thinking start 1: thinking ... 2: content ...
	 */
	private int handleChoices(Res res, StringBuilder thinking, StringBuilder content, int cmd) {
		ResChoiceDelta delta = res.getChoices().get(0).getDelta();
		if (null != delta) {

			String reasoningContent = delta.getReasoning_content();
			String deltaContent = delta.getContent();

			if (reasoningContent != null && !reasoningContent.isBlank()) {
				if (cmd == 0) {
					logThinking("thinking: ");
					cmd = 1;
				}
				logThinking(reasoningContent);
				thinking.append(reasoningContent);
			}

			if (deltaContent != null && !deltaContent.isBlank()) {
				if (cmd == 1) {
					logContent("\n");
					logContent(SEPARATOR + "\n");
					logContent("content: ");
					cmd = 2;
				}
				logContent(deltaContent);
				content.append(deltaContent);
			}
		}
		return cmd;

	}

	private String buildPrompt(List<ReqMsg> messages) {
		Req req = new Req(DEFAULT_MODEL, messages);
		return mapper.writeValueAsString(req);
	}

	private void logThinking(String msg) {
		System.out.print(msg);
	}

	private void logContent(String msg) {
		System.out.print(msg);
	}

	public static void main(String[] args) {
		AIService ai = new AIService();
		List<ReqMsg> messages = new ArrayList<>();
		messages.add(new ReqMsg("user", "你好"));
		ChatResponse chatResponse = ai.chat(messages);

		System.out.println("chatResponse:" + chatResponse);
	}

}
