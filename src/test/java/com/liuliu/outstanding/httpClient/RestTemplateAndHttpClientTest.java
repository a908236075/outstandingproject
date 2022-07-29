package com.liuliu.outstanding.httpClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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

    //    @Test
    public void sendPost() throws IOException, AuthenticationException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://www.baidu.com/");
        httpPost.setEntity(new StringEntity("test post"));
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials("tom", "12345");
        httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));
        CloseableHttpResponse response = client.execute(httpPost);
        int code = response.getStatusLine().getStatusCode();
        Assertions.assertEquals(code, HttpStatus.SC_OK);
    }

    //    @Test
    public void whenUploadFileUsingHttpClient() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://www.baidu.com/");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("file", new File("test.txt"), ContentType.APPLICATION_OCTET_STREAM, "testFile.txt");
        HttpEntity httpEntity = builder.build();
        httpPost.setEntity(httpEntity);
        CloseableHttpResponse response = client.execute(httpPost);
        int code = response.getStatusLine().getStatusCode();
        Assertions.assertEquals(code, HttpStatus.SC_OK);
    }

    @Test
    void uploadFile() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/uploadFile");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("file", new File("src\\main\\resources\\1.txt"), ContentType.APPLICATION_OCTET_STREAM, "1");
        HttpEntity httpEntity = builder.build();
        httpPost.setEntity(httpEntity);
        CloseableHttpResponse response = client.execute(httpPost);
        int code = response.getStatusLine().getStatusCode();
        Assertions.assertEquals(code, HttpStatus.SC_OK);
    }

    @Test
    void getCurrentPath() {
        String path = System.getProperty("user.dir");
        System.out.println(path);
    }

    @Test
    void restTemplateSSL() {
        String urlOverHttps
//                = "https://localhost:8443/httpclient-simple/api/bars/1";
                = "https://www.baidu.com";
        CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        ResponseEntity<String> responseEntity = new RestTemplate(requestFactory).exchange(urlOverHttps, HttpMethod.GET, null, String.class);
        Assertions.assertEquals(responseEntity.getStatusCode().value(), HttpStatus.SC_OK);
    }


    @Test
    void addition() {
        assertEquals(2, 2);
    }


}