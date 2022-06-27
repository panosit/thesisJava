package com.dit.hua.entity;
import javax.persistence.*;

@Entity
@Table(name="CovidCase")
public class CovidCase{

    @Id
    @Column(name="case_id")
    private int case_id;

    @Column(name="username")
    private String username;

    @Column(name="date")
    private String date;

    public CovidCase(){}
    public CovidCase(String username,String date){
        this.username=username;
        this.date=date;
    }
    public int getCase_id(){
        return case_id;
    }
    public void setCase_id(int case_id){
        this.case_id=case_id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }

    @Override
    public String toString(){
        return "CovidCase{"+"case_id="+case_id+", username='"+username+'\''+", date='"+date+'\''+'}';
    }
}