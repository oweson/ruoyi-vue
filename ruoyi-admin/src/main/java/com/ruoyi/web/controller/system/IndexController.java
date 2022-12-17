package com.ruoyi.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author oweson
 * @date 2022/11/26 22:38
 */

@Controller
public class IndexController {

    // 系统首页
    @GetMapping(value = { "/", "/index", "/login" })
    public String index()
    {
        return "index";
    }
}
