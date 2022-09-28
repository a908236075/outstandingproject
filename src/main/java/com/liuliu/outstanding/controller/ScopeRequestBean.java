package com.liuliu.outstanding.controller;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
@Data
public class ScopeRequestBean {
    private String message;
}
