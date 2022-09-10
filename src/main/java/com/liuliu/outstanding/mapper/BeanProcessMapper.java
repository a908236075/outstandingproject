package com.liuliu.outstanding.mapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Lazy;

@AllArgsConstructor
@NoArgsConstructor
@Mapper
@Lazy
public class BeanProcessMapper {
    private String isBetter = "zhagnsan";

    public String getIsBetter() {
        return isBetter;
    }
}
