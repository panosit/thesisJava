package com.dit.hua.dao;
import com.dit.hua.entity.*;
import org.springframework.stereotype.*;
import java.util.*;

@Repository
public interface CovidCaseDAO{
    void insertCovidCase(CovidCase covidCase);
    List<CovidCase> getCovidCases();
}