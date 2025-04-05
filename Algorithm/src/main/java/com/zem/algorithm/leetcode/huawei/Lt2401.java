package com.zem.algorithm.leetcode.huawei;

public class Lt2401 {
    public int longestNiceSubarray(int[] nums) {
        int maxSubArrLength = 0;
        int left = 0;
        int right = 0;
        int or = 0;
        while (right < nums.length) {
            while ((or & nums[right]) > 0) {
                or ^= nums[left++];
            }
            or |= nums[right];
            maxSubArrLength = Math.max(maxSubArrLength, right - left + 1);
            right++;
        }
        return maxSubArrLength;
    }

    public static void main(String[] args) {
        Lt2401 lt2401 = new Lt2401();
        System.out.println(lt2401.longestNiceSubarray(
                new int[]{744437702,379056602,145555074,392756761,560864007,934981918,113312475,1090,16384,33,217313281,117883195,978927664}));
//        1090,16384,33,217313281
//        System.out.println(1090 & 33);
//        System.out.println(16384 & 33);
//        System.out.println(1090);
//        //11001110000100000000000000000001  217313281
//        //00000000000000000000010001000010  1090
        //00000000000000000100000000000000  16384
    }
}
