package com.dit.hua.controller;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import com.dit.hua.dao.*;
import org.springframework.security.access.annotation.*;
import org.springframework.ui.*;
import com.dit.hua.entity.*;
import java.security.*;
import java.time.LocalDate;
import java.util.*;
import javax.servlet.http.*;

@Controller
@RequestMapping("/")
public class UserController{
    @Autowired
    StudentPositionDAO studentPositionDAO;
    @Autowired
    LectureDAO lectureDAO;
    @Autowired
    CovidCaseDAO covidCaseDAO;
    @Secured("ROLE_USER")
    @PostMapping("/covidAdd")
    public String covidCase(HttpServletRequest request,Principal principal,Model model){
        String username=principal.getName();
        model.addAttribute("username",username);
        String date=request.getParameter("date");
        CovidCase covidCase=new CovidCase(username,date);
        covidCaseDAO.insertCovidCase(covidCase);
        List<Lecture> lectures=lectureDAO.getLecturesByDate(String.valueOf(LocalDate.now()));
        model.addAttribute("lectures",lectures);
        return "index";
    }
    @Secured("ROLE_USER")
    @GetMapping("/covid1")
    public String covid(Principal principal,Model model){
        model.addAttribute("username",principal.getName());
        return "covid";
    }
    @Secured("ROLE_USER")
    @GetMapping("/show1")
    public String show(Principal principal,Model model){
        String username=principal.getName();
        model.addAttribute("username",username);
        List<StudentPosition> studentPositions=studentPositionDAO.getStudentPositionsByUser(username);
        model.addAttribute("positions",studentPositions);
        List<Lecture> lectures=new ArrayList<>();
        List<Lecture> lectures1=lectureDAO.getLectures();
        for(StudentPosition studentPosition:studentPositions)
            for(Lecture lecture:lectures1)
                if(studentPosition.getLecture_id()==lecture.getLecture_id())
                        lectures.add(lecture);
        model.addAttribute("lectures",lectures);
        return "show";
    }
    @Secured("ROLE_USER")
    @GetMapping("/index1")
    public String index(Principal principal,Model model){
        model.addAttribute("username",principal.getName());
        List<Lecture> lectures=lectureDAO.getLecturesByDate(String.valueOf(LocalDate.now()));
        model.addAttribute("lectures",lectures);
        return "index";
    }
    @Secured("ROLE_USER")
    @RequestMapping("/lectures/{id}")
    public String lecture(Principal principal,Model model,@PathVariable(value="id") String id){
        model.addAttribute("username",principal.getName());
        Lecture lecture=lectureDAO.getLectureById(Integer.parseInt(id));
        model.addAttribute("lecture",lecture);
        return "position";
    }
    @Secured("ROLE_USER")
    @RequestMapping("/lectures/{id}/addPosition")
    public String addPosition(HttpServletRequest request,Principal principal,Model model,@PathVariable(value="id") String id){
        String username=principal.getName();
        int lecture_id=0;
        try{lecture_id=Integer.parseInt(id);
        }catch(Exception exception){
            System.out.println(exception.getCause());
        }
        String positionNumber=request.getParameter("positionNumber");
        model.addAttribute("username",username);
        StudentPosition studentPosition=new StudentPosition(username,lecture_id,positionNumber);
        studentPositionDAO.insertStudentPosition(studentPosition);
        List<Lecture> lectures=lectureDAO.getLecturesByDate(String.valueOf(LocalDate.now()));
        model.addAttribute("lectures",lectures);
        return "index";
    }
}