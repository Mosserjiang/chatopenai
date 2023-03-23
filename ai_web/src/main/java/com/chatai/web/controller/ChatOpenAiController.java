package com.chatai.web.controller;

import com.chatai.service.ChatOpenAiService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @author mosserjiang
 * @date 2023-03-22
 */
@Controller
@RequestMapping(value = "/chat")
public class ChatOpenAiController {
    @Autowired
    private ChatOpenAiService chatOpenAiService;

    @ResponseBody
    @RequestMapping(value = "/get-chat-info", produces = "application/json;charset=UTF-8", method = {RequestMethod.GET})
    public String openAiChat(@RequestParam("question")String question) throws IOException {
        if(StringUtils.isBlank(question)){
            return "Please Input";
        }
        return chatOpenAiService.chat(question);
    }

    @ResponseBody
    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public String test(){
        return chatOpenAiService.test();
    }
}
