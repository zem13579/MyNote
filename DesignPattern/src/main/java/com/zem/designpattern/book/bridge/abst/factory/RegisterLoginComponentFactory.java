package com.zem.designpattern.book.bridge.abst.factory;

import com.zem.designpattern.book.bridge.abst.AbstractRegisterLoginComponent;
import com.zem.designpattern.book.bridge.abst.RegisterLoginComponent;
import com.zem.designpattern.book.bridge.function.RegisterLoginFuncInterface;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zem
 * @Date 2023/11/9
 * @Describe
 */
public class RegisterLoginComponentFactory {
    public static Map<String, AbstractRegisterLoginComponent> componentMap = new ConcurrentHashMap<>();
    public static Map<String, RegisterLoginFuncInterface> funcInterfaceMap = new ConcurrentHashMap<>();

    public static AbstractRegisterLoginComponent getCompoentMap(String type){
        AbstractRegisterLoginComponent component = componentMap.get(type);
        if(component == null){
            synchronized (componentMap){
                component = componentMap.get(type);
                if(component == null){
                    component = new RegisterLoginComponent(funcInterfaceMap.get(type));
                    componentMap.put(type,component);
                }
            }
        }
        return component;
    }
}
