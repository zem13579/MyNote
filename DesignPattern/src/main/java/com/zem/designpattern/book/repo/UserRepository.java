package com.zem.designpattern.book.repo;

import com.zem.designpattern.book.pojo.UserInfo;


import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author zem
 * @Date 2023/10/30
 * @Describe
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfo,Integer> {

    UserInfo findUserInfoByUserName(String userName);

    UserInfo findUserInfoByUserNameAndUserPassword(String account,String password);
}
