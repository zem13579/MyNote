import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.MybatisPlusDemoApplication;
import org.example.entity.User;
import org.example.entity.UserClass;
import org.example.mapper.ClassMapper;
import org.example.mapper.UserClassMapper;
import org.example.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = MybatisPlusDemoApplication.class)
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private UserClassMapper userClassMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        List<String> userName = new ArrayList<>();
        List<Integer> firstDeptidList = List.of(001);
        List<Integer> secondDeptidList = List.of(110, 111);
        wrapper.in(!userName.isEmpty(), User::getName, userName);
        wrapper.nested(!firstDeptidList.isEmpty() || !secondDeptidList.isEmpty(), sql -> sql.in(User::getFirstDeptId, firstDeptidList).or().in(User::getSecondDeptId, secondDeptidList));
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);

    }

    @Test
    public  void customSqlWrapper(){
//        QueryWrapper qw = new QueryWrapper<>();
//        // 动态SQL
        List<String> userName = List.of("张三");
//        qw.in(!userName.isEmpty(), "t1.name", userName);
//        List<UserClass> userClasses = userMapper.wideQuery(qw);


        LambdaQueryWrapper<UserClass> wrapper = new QueryWrapper<UserClass>().lambda();
        wrapper.in(UserClass::getName,userName);
        userClassMapper.wideQuery(wrapper).forEach(System.out::println);
    }
}
