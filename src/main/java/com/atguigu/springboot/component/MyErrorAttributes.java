package com.atguigu.springboot.component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

//我们自己的错误信息的处理器
@Component
public class MyErrorAttributes  extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        Map ext = (Map) webRequest.getAttribute("ext", 1);
        map.put("ext",ext);
        return map;
    }
}
