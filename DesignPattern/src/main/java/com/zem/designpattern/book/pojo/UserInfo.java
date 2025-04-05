package com.zem.designpattern.book.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author zem
 * @Date 2023/10/30
 * @Describe
 */
@Data
@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private Date createDate;

    @Column
    private String userEmail;
}
