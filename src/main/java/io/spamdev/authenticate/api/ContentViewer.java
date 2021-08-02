package io.spamdev.authenticate.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentViewer
{
    @RequestMapping({"/hello"})
    public String hello()
    {
        return "Hello World";
    }

}
