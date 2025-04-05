package com.zem.algorithm.huawei2024.ex2;

import java.util.*;

public class No17 {

    static Map<Integer,String> ipTable = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ipPools = sc.nextLine();
        String inputs = sc.nextLine();
        sc.close();

        List<IP> ips = new ArrayList<>();

        for (String s : ipPools.split(";")) {
            String[] split = s.split("=");
            String city = split[0];
            String ipStr = split[1];
            String[] startend = ipStr.split(",");

            int ipStart = convertIpToInt(startend[0]);
            int ipEnd = convertIpToInt(startend[1]);
            IP ip = new IP(city, startend[0], startend[1], ipEnd - ipStart + 1);
            ips.add(ip);
        }

        ips.sort(Comparator.comparingInt(o -> o.length));

        for (IP ip : ips) {
            int start = convertIpToInt(ip.start);
            int end = convertIpToInt(ip.end);
            for (int i = start; i <= end; i++) {
                ipTable.put(i,ip.name);
            }
        }
        for (String s : inputs.split(",")) {
            System.out.print(ipTable.get(convertIpToInt(s))+";");
        }


    }

    private static int convertIpToInt(String ip) {
        String[] split = ip.split("\\.");
        int result = 0;
        for (int i = 0; i < split.length; i++) {
            int octet = Integer.parseInt(split[i]);
            result |= (octet << (3-i)*8);
        }
        return result;
    }

    static class IP{
        String name;
        String start;
        String end;
        int length;

        public IP(String name, String start, String end, int length) {
            this.name = name;
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }


}
