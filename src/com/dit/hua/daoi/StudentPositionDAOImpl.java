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
public class StudentPositionDAOImpl implements StudentPositionDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insertStudentPosition(StudentPosition studentPosition){
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(studentPosition);
    }
    @Override
    @Transactional
    public List<StudentPosition> getStudentPositions(){
        Session session=this.sessionFactory.getCurrentSession();
        Query<StudentPosition> query=session.createQuery("from StudentPosition ",StudentPosition.class);
        return query.getResultList();
    }
    @Override
    @Transactional
    public List<StudentPosition> getStudentPositionsByUser(String username){
        Session session=sessionFactory.getCurrentSession();
        Query<StudentPosition> query=session
                .createQuery("from StudentPosition where username='"+username+"'",StudentPosition.class);
        return query.getResultList();
    }
    @Override
    @Transactional
    public List<StudentPosition> getStudentPositionsByUserAndLecture(String username,Lecture lecture){
        Session session=sessionFactory.getCurrentSession();
        Query<StudentPosition> query=session
                .createQuery("from StudentPosition where username='"+username+"'"
                        +" and lecture_id='"+lecture.getLecture_id()+"'",StudentPosition.class);
        return query.getResultList();
    }
}