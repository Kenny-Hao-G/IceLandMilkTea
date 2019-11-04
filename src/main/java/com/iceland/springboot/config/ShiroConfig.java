package com.iceland.springboot.config;


import com.iceland.springboot.shiro.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WWP
 * @description: TODO
 * @date 2019/10/22  14:42
 */
@Configuration
public class ShiroConfig {
   /** 创建管理器对象*/

    @Bean
    public DefaultWebSecurityManager createShiroConfig(MyRealm myRealm){
        return new DefaultWebSecurityManager(myRealm);
    }
   /** 创建Shiro过滤器对象*/
    @Bean
    public ShiroFilterFactoryBean createShiroFilterFactory(DefaultWebSecurityManager defaultWebSecurityManager){
       //创建Shiro工厂对象
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置权限管理对象
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //设置登录页面
        shiroFilterFactoryBean.setLoginUrl("login.html");
        //设置登陆成功后跳转页面
        shiroFilterFactoryBean.setSuccessUrl("index.html");
        //设置未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("error.html");
        //设置拦截规则
        Map<String,String> map=new HashMap<>();
        map.put("/*","anon");
        /*map.put("/static/*","anon");*/
        /*map.put("/*","anon");*/
        map.put("/static/media/**","anon");
        /*map.put("/*","authc");*/
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;

    }



}
