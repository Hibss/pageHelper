package com.jfz.pageHelper.controller;

import com.jfz.pageHelper.mapper.PageInfo.Page;
import com.jfz.pageHelper.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/6/21 15:14
 */
@Controller
public class ViewController {
    private Logger logger = LoggerFactory.getLogger(ViewController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String hello(Model model) {
        Page page = getInitPage();
        model.addAttribute("name", "jinfuzierp-erp");
        model.addAttribute("records",userService.getAll(page));
        logger.info("log on method:{}",this.getClass().getSimpleName() + "."
                + new Exception().getStackTrace()[0].getMethodName());
        return "test";
    }

    private Page getInitPage() {
        return new Page(0,10);
    }
}
