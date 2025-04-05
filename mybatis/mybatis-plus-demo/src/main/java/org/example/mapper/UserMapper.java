package org.example.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.User;
import org.example.entity.UserClass;

import java.util.List;

/**
 * @author zhang
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<UserClass> wideQuery(@Param(Constants.WRAPPER) Wrapper wrappers);
}
