package com.inter.userlogin.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.inter.userlogin.model.Login;
import com.inter.userlogin.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Login());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user) {
        Login authuser = loginService.login(user.getUsername(), user.getPassword());
        System.out.println(authuser);

        System.out.print(authuser);
        if (Objects.nonNull(authuser)) {

            return "redirect:/";

        } else {
            // return "redirect:/login";
            return "index.html";

        }
    }

    @RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/login";
    }
}
