package com.example.mytest.service;

import com.example.mytest.dao.JobTitleDao;
import com.example.mytest.dao.UsersDao;
import com.example.mytest.model.JobTitle;
import com.example.mytest.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleService {
    private final JobTitleDao jobTitleDao;
    @Autowired
    public JobTitleService(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    public JobTitle add(JobTitle jobTitle) {
        return jobTitleDao.save(jobTitle);

    }

    public List<JobTitle> getAll() {
        return jobTitleDao.findAll();
    }


    public JobTitle getById(Long id) {
        return jobTitleDao.getOne(id);
    }


    public JobTitle update(Long id) {
        return getById(id);
    }

    public void remove(Long id) {
        jobTitleDao.deleteById(id);
    }
}
