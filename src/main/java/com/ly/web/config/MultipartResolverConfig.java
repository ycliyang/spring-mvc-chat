package com.ly.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created by liyang on 15/4/4.
 */
@Configuration
public class MultipartResolverConfig {

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver (){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10485760);
        return multipartResolver;
    }


}
