package com.dit.hua.entity;
import javax.persistence.*;

@Entity
@Table(name="StudentPosition")
public class StudentPosition{

    @Id
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="lecture_id")
    private int lecture_id;

    @Column(name="position_number")
    private String position_number;

    public StudentPosition(){}
    public StudentPosition(String username,int lecture_id,String position_number){
        this.username=username;
        this.lecture_id=lecture_id;
        this.position_number=position_number;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public int getLecture_id(){
        return lecture_id;
    }
    public void setLecture_id(int lecture_id){
        this.lecture_id=lecture_id;
    }
    public String getPosition_number(){
        return position_number;
    }
    public void setPosition_number(String position_number){
        this.position_number=position_number;
    }

    @Override
    public String toString() {
        return "StudentPosition{"+"id="+id+", username='"+username+'\''+
                ", lecture_id="+lecture_id+", position_number='"+position_number+'\''+'}';
    }
}