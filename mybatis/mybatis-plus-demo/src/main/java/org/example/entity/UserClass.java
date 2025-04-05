package org.example.entity;

import lombok.Data;

@Data
public class UserClass {
    private Long id;
    private Integer firstDeptId;
    private Integer secondDeptId;
    private String name;
    private Integer age;
    private String email;
    private Integer classId;
    private String className;
}
