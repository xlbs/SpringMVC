package com.springmvc.spring;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;
import java.util.Map;

public class ManyViewResolver implements ViewResolver {

    private Map<String,ViewResolver> resolvers;

    public void setResolvers(Map<String, ViewResolver> resolvers) {
        this.resolvers = resolvers;
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        int n=viewName.lastIndexOf(".");
        if(n!=-1){
            //取出扩展名
            String suffix=viewName.substring(n+1);
            //取出对应的ViewResolver
            ViewResolver resolver = resolvers.get(suffix);
            if(resolver==null){
                throw new RuntimeException("No ViewResolver for："+viewName);
            }
            return  resolver.resolveViewName(viewName, locale);
        }else{
            throw new RuntimeException("No ViewResolver for：'"+viewName+" '请加上扩展名");
        }
    }


}
