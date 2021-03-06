package com.example.kursach2tkp.controllers;

import com.example.kursach2tkp.dao.AuthoritiesDAO;
import com.example.kursach2tkp.models.Authority;
import com.example.kursach2tkp.models.User;
import com.example.kursach2tkp.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private UserDetailsServiceImpl userDetailsService;

    private AuthoritiesDAO authoritiesDAO;

    @Autowired
    public void setUserDetailsService(UserDetailsServiceImpl userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void setAuthoritiesDAO(AuthoritiesDAO authoritiesDAO){
        this.authoritiesDAO = authoritiesDAO;
    }

    @GetMapping("/login")
    public String login(Authentication authentication){
        return "auth/auth/Войти";
    }

    @GetMapping("/registration")
    public String registration(){
        return "auth/auth/Зарегистрироваться";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam(value = "login") String login,
                          @RequestParam(value = "password") String password,
                          @RequestParam(value = "email") String email,
                          Model model){

        Authority authority = authoritiesDAO.getAuthorityByName("USER");
        if(authority == null){
            authority = new Authority();
            authority.setRole("USER");
            authoritiesDAO.createAuthority(authority);
        }

        User newUser = new User();
        newUser.setLogin(login.toLowerCase(Locale.ROOT));
        newUser.setPassword(password);
        newUser.setEmail(email.toLowerCase(Locale.ROOT));
        newUser.setAuthorities(authority);

        if(!userDetailsService.saveUser(newUser)){
            return "redirect:/auth/registration?collision_error";
        }
        return "redirect:/subjects";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
          Authentication auth = SecurityContextHolder.getContext().getAuthentication();
          if (auth != null) {
              new SecurityContextLogoutHandler().logout(request, response, auth);
          }

          return "redirect:/subjects";
      }
}
