package com.example.mytest.dao;

import com.example.mytest.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersDao extends JpaRepository <Users,Long> {


}
