package com.dit.hua.dao;
import com.dit.hua.entity.*;
import org.springframework.stereotype.*;
import java.util.*;

@Repository
public interface LectureDAO{
    void insertLecture(Lecture lecture);
    List<Lecture> getLectures();
    List<Lecture> getLecturesByDate(String date);
    Lecture getLectureById(int id);
}