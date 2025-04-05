package com.zem.algorithm.swordoffer;

/**
 * https://www.nowcoder.com/share/jump/5635376671693324549665
 * 替换空格
 */
public class Code04 {
    public static void main(String[] args) {
        Code04 code04 = new Code04();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("We Are Happy");
        String s = code04.replaceSpace2(stringBuffer);
        System.out.println(s);
    }

    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

    public String replaceSpace2(StringBuffer str) {
        char[] charArray = str.toString().toCharArray();
        //判断新数组大小
        int countWhiteSpace = 0;
        for (char c : charArray) {
            if (c == ' ') {
                countWhiteSpace++;
            }
        }
        int newLength = charArray.length + countWhiteSpace * 2;
        char[] newStrChars = new char[newLength];
        int indexOfOriginal = charArray.length - 1;
        int indexOfNew = newLength - 1;
        while (indexOfOriginal >= 0 && indexOfNew >= indexOfOriginal) {
            if (charArray[indexOfOriginal] == ' ') {
                newStrChars[indexOfNew--] = '0';
                newStrChars[indexOfNew--] = '2';
                newStrChars[indexOfNew--] = '%';
            } else {
                newStrChars[indexOfNew--] = charArray[indexOfOriginal];
            }
            indexOfOriginal--;
        }
        return new String(newStrChars);
    }
}
