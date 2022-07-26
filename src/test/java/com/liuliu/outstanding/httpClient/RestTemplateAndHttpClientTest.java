package com.liuliu.outstanding.httpClient;

import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RestTemplateAndHttpClientTest {

    @BeforeAll
    public static void getTest() {
        System.out.println("https test!!!");
    }

    @Test
    public void httpClientTest() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse response = httpClient.execute(new HttpGet("https://www.baidu.com/"));
        int code = response.getStatusLine().getStatusCode();
        Assertions.assertEquals(code, HttpStatus.SC_OK);
    }

    @Test
    public void timeoutTest() throws IOException {
        int timeout = 5;
        RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout * 1000).setConnectionRequestTimeout(timeout * 1000).setSocketTimeout(timeout * 1000).build();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        CloseableHttpResponse response = client.execute(new HttpGet("https://www.baidu.com/"));
        int code = response.getStatusLine().getStatusCode();
        Assertions.assertEquals(code, HttpStatus.SC_OK);
    }


    @Test
    void addition() {
        assertEquals(2, 2);
    }


}