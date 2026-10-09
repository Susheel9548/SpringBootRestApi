package com.rest.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.springboot.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
