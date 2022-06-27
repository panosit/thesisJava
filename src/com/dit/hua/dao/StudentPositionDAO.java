package com.dit.hua.dao;
import com.dit.hua.entity.*;
import org.springframework.stereotype.*;
import java.util.*;

@Repository
public interface StudentPositionDAO{
    void insertStudentPosition(StudentPosition studentPosition);
    List<StudentPosition> getStudentPositions();
    List<StudentPosition> getStudentPositionsByUser(String username);
    List<StudentPosition> getStudentPositionsByUserAndLecture(String username,Lecture lecture);
}