package com.chatai.service;

import java.io.IOException;

/**
 * @author mosserjiang
 * @date 2023-03-22
 */
public interface ChatOpenAiService {
    /**
     * 聊天
     * @param question 问题
     * @return String
     */
    String chat(String question) throws IOException;

    /**
     * 测试
     * @return String
     */
    String test();
}
