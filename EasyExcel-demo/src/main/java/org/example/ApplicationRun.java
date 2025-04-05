package org.example;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ApplicationRun implements ApplicationRunner {

    @Autowired
    private DataImportConfig colConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Map<String, Class<?>> fieldTypes = new HashMap<>();
        fieldTypes.put("name", String.class);
        fieldTypes.put("age", Integer.class);

        Object dynamicPojo = generatePojoWithFields(fieldTypes);

        BeanWrapper beanWrapper = new BeanWrapperImpl(dynamicPojo);
        System.out.println(beanWrapper.getPropertyValue("name"));
    }

    public static Object generatePojoWithFields(Map<String, Class<?>> fieldTypes) {
        BeanGenerator generator = new BeanGenerator();
        fieldTypes.forEach(generator::addProperty);

        Object generatedObject = generator.create();
        BeanMap beanMap = BeanMap.create(generatedObject);

        // 设置字段的值（可选）
        fieldTypes.keySet().forEach(fieldName -> {
            Class<?> fieldType = fieldTypes.get(fieldName);
            if (fieldType == String.class) {
                beanMap.put(fieldName, "my name is tom");
            } else if (fieldType == Integer.class) {
                beanMap.put(fieldName, 0);
            }
            // 根据不同的类型进行不同的初始化
        });

        return generatedObject;
    }
}
