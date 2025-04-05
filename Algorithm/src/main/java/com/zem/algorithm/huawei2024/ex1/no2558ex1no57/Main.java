package com.zem.algorithm.huawei2024.ex1.no2558ex1no57;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/12 0012 10:23
 */
public class Main {
    
    static class Flight {
        
        public String flightNo;
        
        public String company;
        
        public String flightInfoNum;
        
        public Flight(String flightNo) {
            this.flightNo = flightNo;
            this.company = flightNo.substring(0, 2);
            this.flightInfoNum = flightNo.substring(2);
        }
        
        public String getFlightNo() {
            return flightNo;
        }
        
        public String getCompany() {
            return company;
        }
        
        public String getFlightInfoNum() {
            return flightInfoNum;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Arrays.stream(sc.nextLine().split(",")).flatMap(x -> Stream.of(new Flight(x)))
                .sorted(Comparator.comparing(Flight::getCompany).thenComparing(Flight::getFlightInfoNum))
                .flatMap(x -> Stream.of(x.getFlightNo())).collect(Collectors.joining(",")));
        sc.close();
    }
    
}
