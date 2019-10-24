package com.iceland.springboot.config;

import com.iceland.springboot.shiro.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Configuration：标记这是个配置类
 * @ClassName:Shiro
 * @Author:kennymoon
 * @Date:2019/10/23 12:54 下午
 */
@Configuration
public class ShiroConfig {

    /**
     * 1. 创建权限管理器对象
     *
     * @param realm
     * @return
     */
    @Bean
    public DefaultWebSecurityManager createSM(MyRealm realm){
        System.out.println(realm);
        return new DefaultWebSecurityManager(realm);
    }

    /**
     * 2. 创建 Shiro 过滤器对象
     *
     * @param webSecurityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean createSF(DefaultWebSecurityManager webSecurityManager) {
        // 1. 创建 Shiro 过滤器工厂对象
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        // 2. 设置权限管理器对象
        factoryBean.setSecurityManager(webSecurityManager);
        // 3. 设置三个常用的 URL 页面
        factoryBean.setLoginUrl("login.html");
        factoryBean.setSuccessUrl("index.html");
        // 3.1 设置未授权的页面
        factoryBean.setUnauthorizedUrl("error.html");
        // 4. 设置拦截规则 anon : 匿名访问 访问 谁都可以使用 authc: 认证访问 必须登录方可使用
        Map<String, String> map = new HashMap<>();
        map.put("/login.html", "anon");
        map.put("/user/login", "anon");
        map.put("/swagger-ui.html", "anon");
        // 静态资源 放行
        map.put("/media/**", "anon");
        // 其他全部拦截
        // map.put("/*", "authc");
        // 将 map 放到拦截器中
        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }
}
