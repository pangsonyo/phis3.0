package com.pyhis.orgmanagment.repository;

import com.pyhis.orgmanagment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

    User findUserByUserName(String name);

    int getCountByUserName(String name);

    User findUserByUserNameAndPassword(String name,String password);
}
