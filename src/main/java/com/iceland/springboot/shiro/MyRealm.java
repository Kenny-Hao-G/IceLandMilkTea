package com.iceland.springboot.shiro;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import org.springframework.stereotype.Component;



/**
 * @author WWP
 * @description: TODO
 * @date 2019/10/22  14:46
 */
@Component
public class MyRealm extends AuthorizingRealm {
    /*@Autowired
    private UserDao userDao;*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       /* User user= (User) SecurityUtils.getSubject().getSession().getAttribute("USERNAME");
        List<String> perms=userDao.selectPerms(user.getId());

        SimpleAuthorizationInfo simpleAuthorizationInfo= new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(perms);*/
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
       if (token.getUsername() !=null){
           SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(token.getPrincipal(),token.getPassword(),token.getUsername());
           return simpleAuthenticationInfo;
       }

        return null;
    }
}
