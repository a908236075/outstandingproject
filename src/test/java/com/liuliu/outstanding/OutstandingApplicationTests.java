package com.liuliu.outstanding;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class OutstandingApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void uploadFile() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/uploadFile");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("file", new File("D:\\develop\\gitHub\\outstandingproject\\src\\main\\resources\\"), ContentType.APPLICATION_OCTET_STREAM, "1.txt");
        HttpEntity httpEntity = builder.build();
        CloseableHttpResponse response = client.execute(httpPost);
        int code = response.getStatusLine().getStatusCode();
        Assertions.assertEquals(code, HttpStatus.SC_OK);
    }

}
