package com.zem.designpattern.book.adapter;

public interface Login3rdTarget {

    String loginByGitee(String code,String state);
    String loginByWeChat(String code,String state);
}
