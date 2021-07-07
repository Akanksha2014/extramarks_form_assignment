package com.extramarks.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.extramarks.data.User;

/** 
 * This interface provides the access of methods from JpaRepository */

public interface UserDao extends JpaRepository<User, Long>{

}
