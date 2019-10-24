package com.iceland.springboot.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Spring IOC 创建对象
 *
 * @ClassName:MyRealm
 * @Author:kennymoon
 * @Date:2019/10/23 12:56 下午
 */
@Component
public class MyRealm extends AuthorizingRealm {

    /**
     * 1. 授权 查询登录用户的角色
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /*// 1. 获取登录的用户
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("curruser");
        // 2. 查询当前用户所有的权限
        List<String> perms = userDao.selectPerms(user.getId());
        // 3. 实例化授权对象
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 4. 赋值
        authorizationInfo.addStringPermissions(perms);

        return authorizationInfo;
         */
        return null;
    }

    /**
     * 2. 认证 生成凭证 登录成功
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        if (token.getUsername() != null) {
            // token 获取到用户名 登录成功
            AuthenticationInfo info =
                    new SimpleAuthenticationInfo(token.getPrincipal(), token.getPassword(), getName());
            return info;
        }
        return null;
    }
}
