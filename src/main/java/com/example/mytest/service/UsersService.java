package com.example.mytest.service;


import com.example.mytest.dao.UsersDao;
import com.example.mytest.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private final UsersDao usersdao;
    @Autowired
    public UsersService(UsersDao usersdao) {
        this.usersdao = usersdao;
    }

    public Users add(Users users) {
       return usersdao.save(users);

    }

    public List<Users> getAll() {
        return usersdao.findAll();
    }


    public Users getById(Long id) {
        return usersdao.getOne(id);
    }


    public Users update(Long id) {
        return getById(id);
    }

    public void remove(Long id) {
        usersdao.deleteById(id);
    }
}
