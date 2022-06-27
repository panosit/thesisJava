package com.dit.hua.controller;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import com.dit.hua.dao.*;
import org.springframework.security.access.annotation.*;
import org.springframework.ui.*;
import com.dit.hua.entity.*;
import java.security.*;
import javax.servlet.http.*;
import java.util.*;

@Controller
@RequestMapping("/")
public class AdminController{
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CovidCaseDAO covidCaseDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    AuthoritiesDAO authoritiesDAO;
    @Autowired
    LectureDAO lectureDAO;
    @Autowired
    StudentPositionDAO studentPositionDAO;
    @Secured("ROLE_ADMIN")
    @PostMapping("/addUser")
    public String addUser(HttpServletRequest request,Model model,Principal principal){
        model.addAttribute("username",principal.getName());
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String password1=request.getParameter("password1");
        List<User> users=userDAO.getUserByUsername(username);
        if(password.equals(password1)&&users.size()==0){
            User user=new User(username,passwordEncoder.encode(password),1);
            userDAO.insertUser(user);
            Authorities authorities=new Authorities(username,"ROLE_USER");
            authoritiesDAO.insertAuthorities(authorities);
            model.addAttribute("result","User has been created!");
        }
        else if(users.size()>0)
            model.addAttribute("result","Username exists!");
        else if(password.equals(password1)==false)
            model.addAttribute("result","Passwords are different");
        return "index";
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/index")
    public String index(Principal principal,Model model){
        model.addAttribute("username",principal.getName());
        return "index";
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/show")
    public String show(Principal principal,Model model){
        model.addAttribute("username",principal.getName());
        List<StudentPosition> studentPositions=studentPositionDAO.getStudentPositions();
        model.addAttribute("positions",studentPositions);
        List<Lecture> lectures=lectureDAO.getLectures();
        model.addAttribute("lectures",lectures);
        return "show";
    }
    @Secured("ROLE_ADMIN")
    @GetMapping("/covid")
    public String covid(Principal principal,Model model){
        model.addAttribute("username",principal.getName());
        List<CovidCase> covidCases=covidCaseDAO.getCovidCases();
        model.addAttribute("covidCases",covidCases);
        return "covid";
    }
    @Secured("ROLE_ADMIN")
    @PostMapping ("/addLecture")
    public String addLecture(Principal principal,Model model,HttpServletRequest request){
        model.addAttribute("username",principal.getName());
        String lesson=request.getParameter("lesson");
        String starting_hour=request.getParameter("starting_hour");
        String ending_hour=request.getParameter("ending_hour");
        String amphitheater=request.getParameter("amphitheater");
        String lesson_type=request.getParameter("lesson_type");
        String professor=request.getParameter("professor");
        String date=request.getParameter("date");
        Lecture lecture=new Lecture(date,lesson,starting_hour,ending_hour,
                amphitheater,lesson_type,professor);
        lectureDAO.insertLecture(lecture);
        model.addAttribute("result1","Lecture "+lesson+" added!");
        return "index";
    }
}