package com.vserdiuk.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vserdiuk on 6/8/16.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    String home() {
        return "index";
    }

}
