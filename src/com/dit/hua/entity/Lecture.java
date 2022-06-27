package com.dit.hua.entity;
import javax.persistence.*;

@Entity
@Table(name="Lecture")
public class Lecture{

    @Id
    @Column(name="lecture_id")
    private int lecture_id;

    @Column(name="date")
    private String date;

    @Column(name="lesson")
    private String lesson;

    @Column(name="starting_hour")
    private String starting_hour;

    @Column(name="ending_hour")
    private String ending_hour;

    @Column(name="amphitheater")
    private String amphitheater;

    @Column(name="lesson_type")
    private String lesson_type;

    @Column(name="professor")
    private String professor;

    public Lecture(){}
    public Lecture(String date,String lesson,
                   String starting_hour,String ending_hour,String amphitheater,
                   String lesson_type,String professor){
        this.date=date;
        this.lesson=lesson;
        this.starting_hour=starting_hour;
        this.ending_hour=ending_hour;
        this.amphitheater=amphitheater;
        this.lesson_type=lesson_type;
        this.professor=professor;
    }
    public int getLecture_id(){
        return lecture_id;
    }
    public void setLecture_id(int lecture_id){
        this.lecture_id=lecture_id;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }
    public String getLesson(){
        return lesson;
    }
    public void setLesson(String lesson){
        this.lesson=lesson;
    }
    public String getStarting_hour(){
        return starting_hour;
    }
    public void setStarting_hour(String starting_hour){
        this.starting_hour=starting_hour;
    }
    public String getEnding_hour(){
        return ending_hour;
    }
    public void setEnding_hour(String ending_hour){
        this.ending_hour=ending_hour;
    }
    public String getAmphitheater(){
        return amphitheater;
    }
    public void setAmphitheater(String amphitheater){
        this.amphitheater=amphitheater;
    }
    public String getLesson_type(){
        return lesson_type;
    }
    public void setLesson_type(String lesson_type){
        this.lesson_type=lesson_type;
    }
    public String getProfessor(){
        return professor;
    }
    public void setProfessor(String professor){
        this.professor=professor;
    }

    @Override
    public String toString(){
        return "Lecture{"+"lecture_id="+lecture_id+", date='"+date+'\''+
                ", lesson='"+lesson+'\''+", starting_hour='"+starting_hour+'\''+
                ", ending_hour='"+ending_hour+'\''+", amphitheater='"+amphitheater+'\''+
                ", lesson_type='"+lesson_type+'\''+", professor='"+professor+'\''+'}';
    }
}