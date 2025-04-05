package com.zem.designpattern.book.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;

import java.io.IOException;

/**
 * @Author zem
 * @Date 2023/11/5
 * @Describe
 */
public class HttpClientUtils {
    public static JSONObject execute(String url, HttpMethod httpMethod){
        HttpRequestBase http = null;
        try{
            HttpClient httpClient = HttpClients.createDefault();
            if(httpMethod == HttpMethod.GET){
                http = new HttpGet(url);
            }else{
                http = new HttpPost(url);
            }
            HttpEntity entity = httpClient.execute(http).getEntity();
            return JSONObject.parseObject(EntityUtils.toString(entity));
        }catch (IOException ex){
            throw new RuntimeException("Requst fialed url = "+url);
        }finally {
            http.releaseConnection();
        }
    }
}
