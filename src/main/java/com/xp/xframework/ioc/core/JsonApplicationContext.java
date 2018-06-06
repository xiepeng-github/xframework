package com.xp.xframework.ioc.core;

import com.xp.xframework.ioc.bean.BeanDefinition;
import com.xp.xframework.ioc.factory.support.DefaultBeanFactory;
import com.xp.xframework.ioc.io.ClassPathResource;
import com.xp.xframework.ioc.utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author xp
 */
public class JsonApplicationContext extends DefaultBeanFactory{

    public JsonApplicationContext(String fileName) throws IOException {
        
        InputStream is = new ClassPathResource(fileName).getInputStream();

        List<BeanDefinition> beanDefinitions = JsonUtils.readValue(is,new TypeReference<List<BeanDefinition>>(){});

        if(beanDefinitions != null && !beanDefinitions.isEmpty()) {

            for (BeanDefinition beanDefinition : beanDefinitions) {
                registerBean(beanDefinition.getName(), beanDefinition);
            }
        }
        
    }

}
