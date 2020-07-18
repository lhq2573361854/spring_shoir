package com.tianling.shiro.realm;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.util.StringUtils;

/**
 * @author: TianLing
 * @Year: 2020
 * @DateTime: 2020/7/16 17:52
 */
@Slf4j
public class DemoRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        log.info("获取授权信息");
        info.addStringPermission("user:add");
        info.addRole("user");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        log.info("DemoRealm:获取身份验证");
        String name  = "tianling";
        String pass = "098d2c478e9c11555ce2823231e02ec1";
        token.setRememberMe(true);
        if (!StrUtil.equals(name,token.getUsername())){
            return null;
        }

        return new SimpleAuthenticationInfo(token.getUsername()
                ,pass, new SimpleByteSource("user"),getName());
    }
}
