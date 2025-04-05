package org.example.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zhang
 */
@Data
@TableName("`user`")
public class User {
    @TableId
    private Long id;
    private Integer firstDeptId;
    private Integer secondDeptId;
    private String name;
    private Integer age;
    private String email;
    private Integer classId;
}