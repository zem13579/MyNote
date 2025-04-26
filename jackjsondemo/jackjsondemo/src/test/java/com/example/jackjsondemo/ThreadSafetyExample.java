package com.example.jackjsondemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSafetyExample {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                // 多线程共享同一个 sdf 实例解析日期
                Date date = sdf.parse("2023-10-17");
                System.out.println(Thread.currentThread().getName() + " Parsed: " + date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // 启动 10 个线程并发解析
        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }
    }

}
