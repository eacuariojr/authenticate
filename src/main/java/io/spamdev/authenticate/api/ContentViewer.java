package io.spamdev.authenticate.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContentViewer
{
    @GetMapping("/hello")
    @ResponseBody
    public String hello()
    {
        return "Hello World";
    }

}
