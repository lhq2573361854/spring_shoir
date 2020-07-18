# Shiro
常用过滤器
---
anon:无需认证可以访问

authc:必须认证才可以访问

user:如果使用rememberMe的功能可以直接访问

perms:必须获取资源访问权限才可以访问
 
logout

过滤器 支持ant风格 url 采取第一次匹配优先的方式
- ?
- \*
- **  



role:必须获取角色才可以访问
---
shiroFilter

DelegatingFilterProxy是filter的一个代理对象默认使用filter name和target name来配置bean的id

SimpleAuthenticationInfo(Object 可以是密码可以使entity, Object 密码,ByteSource 一个盐,  String subject.getName()) {

使用AuthorizingRealm 中的 CredentialsMatcher 进行密码比对

SimpleAuthorizationInfo 权限的验证信息

可以使用注解的方式配置访问的权限

FilterChainDefinitionMap 可以配置拦截的url需要的权限

会话管理

在service层中也可以访问到controller层的数据SecurityUtil.getSubject.getSession;

Session