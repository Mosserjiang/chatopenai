package com.chatai.service.impl;

import com.chatai.service.ChatOpenAiService;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author mosserjiang
 * @date 2023-03-22
 */
@Service
@Slf4j
public class ChatOpenAiServiceImpl implements ChatOpenAiService {
    @Value("${open.ai.modelChat}")
    private String modelChat;
    @Value("${open.ai.key}")
    private String openAiKey;

    @Override
    public String chat(String question) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(180, TimeUnit.SECONDS)
                .readTimeout(180, TimeUnit.SECONDS)
                .build();

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        String requestBody = "{\"model\":\""+ modelChat +"\",\"messages\":[{\"role\":\"user\",\"content\":\""+ question +"\"}]}";

        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/chat/completions")
                .header("Authorization", "Bearer " + openAiKey)
                .header("Content-Type", "application/json")
                .post(RequestBody.create(mediaType, requestBody))
                .build();

        Call call = client.newCall(request);
        call.timeout().timeout(180, TimeUnit.SECONDS);
        Response response = call.execute();

        String responseBody = response.body().string();
       return responseBody;
    }
}
