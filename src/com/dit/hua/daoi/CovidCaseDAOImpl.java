package com.dit.hua.daoi;
import com.dit.hua.dao.*;
import com.dit.hua.entity.*;
import org.springframework.stereotype.*;
import java.util.*;
import javax.transaction.*;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.*;

@Repository
public class CovidCaseDAOImpl implements CovidCaseDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void insertCovidCase(CovidCase covidCase){
        Session session=this.sessionFactory.getCurrentSession();
        session.save(covidCase);
    }

    @Override
    @Transactional
    public List<CovidCase> getCovidCases(){
        Session session=this.sessionFactory.getCurrentSession();
        Query<CovidCase> query=session.createQuery("from CovidCase ",CovidCase.class);
        return query.getResultList();
    }
}
