package com.henry.bitcoin.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.jsonrpc4j.spring.rest.JsonRpcRestClient;
import org.springframework.util.Base64Utils;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class RpcApiTemplate {

    private JsonRpcRestClient client;

    private ObjectMapper objectMapper;

    public RpcApiTemplate(String url) {
        //init(url, username, password);
    }

    public RpcApiTemplate(String url, String username, String password) {
        init(url, username, password);
    }

    protected void invoke(String method, Object argument) {

        try {
            client.invoke(method, argument);
        } catch (Throwable throwable) {
            throw new IllegalArgumentException("### rpc invoke error. method: " + method + ", argument: " + String.valueOf(argument), throwable);
        }
    }

    protected <T> T invoke(String method, Object argument, Type type) {

        return doInvoke(method, argument, type);
    }

    protected <T> T invokeByArray(String method, Object[] arguments, Type type) {

        return doInvoke(method, arguments, type);
    }

    protected <T> T invokeByList(String method, List<Object> arguments, Type type) {

        return doInvoke(method, arguments, type);
    }

    protected <T> T invokeByMap(String method, Map<String, Object> arguments, Type type) {

        return doInvoke(method, arguments, type);
    }

    protected <T> T invoke(String method, Object argument, Class<T> clazz) {

        return doInvoke(method, argument, clazz);
    }

    protected <T> T invokeByArray(String method, Object[] arguments, Class<T> clazz) {

        return doInvoke(method, arguments, clazz);
    }

    protected <T> T invokeByList(String method, List<Object> arguments, Class<T> clazz) {

        return doInvoke(method, arguments, clazz);
    }

    protected <T> T invokeByMap(String method, Map<String, Object> arguments, Class<T> clazz) {

        return doInvoke(method, arguments, clazz);
    }

    protected JsonRpcRestClient getClient() {
        return client;
    }

    protected ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    private <T> T doInvoke(String method, Object argument, Class<T> clazz) {
        try {
            return client.invoke(method, argument, clazz);
        } catch (Throwable throwable) {
            throw new IllegalArgumentException("### rpc invoke error. method: " + method + ", argument: " + String.valueOf(argument), throwable);
        }
    }

    private <T> T doInvoke(String method, Object argument, Type type) {
        try {

            return (T) client.invoke(method, argument, type);
        } catch (Throwable throwable) {
            throw new IllegalArgumentException("### rpc invoke error. method: " + method + ", argument: " + String.valueOf(argument), throwable);
        }
    }

    private void init(String url, String username, String password) {

        try {

            URL urlToUse = new URL(url);

            String token = createToken(username, password);

            Map<String, String> headers = createHeaders(token);

            client = new JsonRpcRestClient(urlToUse, headers);

            objectMapper = client.getObjectMapper();

        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("### 초기화 실패, 잘못된 URL입니다, url: " + url, e);

        } catch (Exception e) {
            throw new IllegalArgumentException("### 초기화 실패.", e);
        }
    }

    private Map<String, String> createHeaders(String token) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Basic " + token);

        return headers;
    }

    private String createToken(String username, String password) {

        String token = Base64Utils.encodeToString((username + ":" + password).getBytes(Charset.forName("UTF-8")));

        return token;
    }
}
