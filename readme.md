### 认证流程
![img_1.png](img_1.png)

### 过滤链中主要的几个过滤器及其作用： 
<b>SecurityContextPersistenceFilter</b>:是整个拦截过程的入口和出口 负责初始化一些环境。

<b>UsernamePasswordAuthenticationFilter</b>:
处理来自表单提交的认证。该表单必须提供对应的账号密码，其内部还有登录成功或失败后进行处理
的 AuthenticationSuccessHandler 和 AuthenticationFailureHandler,这些都可以根据
需要做相关改变。

<b>FilterSecurityInterceptor</b>: 保护web资源，使用 AccessDecisionManager 对当前用户进行
授权访问 。

<b>ExceptionTranslationFilter</b>: 能捕获来自 FilterChain 所有的异常，并进行处理。只会处理两类
异常：AuthenticationException 和 AccessDeniedException,其他异常会继续抛出。



