package com.liuliu.outstanding.handbook;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceApplication {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext();
        Resource resource = ctx.getResource("/1/1.txt");
        System.out.println(resource.getFilename());
    }
}
