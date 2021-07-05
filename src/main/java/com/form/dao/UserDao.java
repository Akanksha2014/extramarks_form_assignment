package com.form.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.form.data.User;

/** 
 * This interface provides the access of methods from JpaRepository */

public interface UserDao extends JpaRepository<User, Long>{

}
