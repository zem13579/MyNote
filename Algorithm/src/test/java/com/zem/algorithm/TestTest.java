package com.zem.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestTest {
    @Test
    public void test() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        
        // 获取map的values视图
        Collection<Integer> values = map.values();
        
        // 输出原始Map的值
        System.out.println("原始Map的值: " + map.values());
        
        // 通过values视图删除一个值
        values.remove(2);
        
        // 输出修改后的Map的值
        map.forEach((key, value) -> System.out.println(key + "," + value));
    }
}
