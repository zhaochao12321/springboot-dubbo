package sendMail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sendMail.service.SendMailService;

@Controller
public class SendMailController {

    @Autowired
    SendMailService sendMailService;

    @GetMapping("/xiaobai")
    public void sendMail(){
        sendMailService.sendMail();

    }



}
