package com.zem.algorithm.huawei2024.ex1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/13 0013 10:48
 */
public class No71 {
    
    static class App {
        
        public String name;
        
        public int priority;
        
        public int startTime;
        
        public int endTime;
        
        public App(String infoline) {
            String[] split = infoline.split(" ");
            this.name = split[0];
            this.priority = Integer.parseInt(split[1]);
            this.startTime = convertTime(split[2]);
            this.endTime = convertTime(split[3]);
        }
        
        
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            App app = (App) o;
            return priority == app.priority && startTime == app.startTime && endTime == app.endTime && Objects.equals(
                    name, app.name);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(name, priority, startTime, endTime);
        }
    }
    
    static class Apps {
        
        Map<Integer, App> map = new HashMap<>();
        
        public void unregister(App app) {
            if (app.startTime >= app.endTime) {
                return;
            }
            if (map.isEmpty()) {
                for (int i = app.startTime; i < app.endTime; i++) {
                    map.put(i, app);
                }
                return;
            }
            Set<App> tmpApp = new HashSet<>();
            for (Integer time : map.keySet()) {
                if (time >= app.startTime && time < app.endTime) {
                    if (map.get(time) != null) {
                        tmpApp.add(map.get(time));
                        if (map.get(time).priority >= app.priority) {
                            //优先级高或相同，无法注册
                            return;
                        }
                    }
                }
            }
            //可以注册 ，先注销其他pp
            unregister(tmpApp);
            
            //
            for (int i = app.startTime; i < app.endTime; i++) {
                map.put(i, app);
            }
        }
        
        public void unregister(Set<App> apps) {
            map = this.map.entrySet().stream().filter(integerAppEntry -> !apps.contains(integerAppEntry.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }
        
        public App get(String time) {
            return map.getOrDefault(convertTime(time), null);
        }
        
    }
    
    public static int convertTime(String timeStr) {
        String[] tmp = timeStr.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
    
    /**
     * 2 App1 1 09:00 10:00 App2 2 09:10 09:30 09:20
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Apps apps = new Apps();
        for (int i = 0; i < n; i++) {
            apps.unregister(new App(sc.nextLine()));
        }
        String time = sc.nextLine();
        App app = apps.get(time);
        System.out.println(app == null ? "NULL" : app.name);
    }
}
