package soenke.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/start")
public class ApplicationController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public void start() throws InterruptedException {
        simpMessagingTemplate.convertAndSend("/topic/greetings", "Hi!");
        Thread.sleep(200);
        simpMessagingTemplate.convertAndSend("/topic/greetings", "Hello!");
        Thread.sleep(200);
        simpMessagingTemplate.convertAndSend("/topic/greetings", "Hola!");
    }
}
