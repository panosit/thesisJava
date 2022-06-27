package com.dit.hua.daoi;
import com.dit.hua.dao.*;
import com.dit.hua.entity.*;
import org.hibernate.query.Query;
import org.springframework.stereotype.*;
import javax.transaction.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

@Repository
public class LectureDAOImpl implements LectureDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insertLecture(Lecture lecture){
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(lecture);
    }
    @Override
    @Transactional
    public List<Lecture> getLectures(){
        Session session=this.sessionFactory.getCurrentSession();
        Query<Lecture> query=session.createQuery("from Lecture ",Lecture.class);
        return query.getResultList();
    }
    @Override
    @Transactional
    public List<Lecture> getLecturesByDate(String date){
        Session session=this.sessionFactory.getCurrentSession();
        Query<Lecture> query=session.createQuery("from Lecture where date='"+date+"'",Lecture.class);
        return query.getResultList();
    }
    @Override
    @Transactional
    public Lecture getLectureById(int id){
        Session session=this.sessionFactory.getCurrentSession();
        Query<Lecture> query=session.createQuery("from Lecture where lecture_id="+
                id,Lecture.class);
        return query.getSingleResult();
    }
}