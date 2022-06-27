package com.dit.hua.controller;
import com.dit.hua.dao.LectureDAO;
import com.dit.hua.entity.Lecture;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import java.security.*;
import java.time.LocalDate;
import java.util.List;
import org.springframework.security.core.context.*;
import org.springframework.security.web.authentication.logout.*;
import javax.servlet.http.*;

@Controller
@RequestMapping("/")
public class MainController{
    @Autowired
    LectureDAO lectureDAO;
	@RequestMapping("/")
    public String home(Model model,Principal principal){
		model.addAttribute("username",principal.getName());
        List<Lecture> lectures=lectureDAO.getLecturesByDate(String.valueOf(LocalDate.now()));
        model.addAttribute("lectures",lectures);
    	return "index";
    }
    @RequestMapping("/login")
    public String showLogin(){
            return "login";
    }
    @RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null)
			new SecurityContextLogoutHandler().logout(request,response,authentication);
		return "redirect:login";
    }
}