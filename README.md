# bboss-spring-boot-starter

bboss 持久层和http proxy spring boot集成组件，兼容spring boot 1.x,2.x,3.x,+
# 导入bboss starter
## spring boot 1.x,2.x导入maven坐标

```groovy
api(
[group: 'com.bbossgroups', name: 'bboss-spring-boot-starter', version: '6.3.3', transitive: true],
 )
```

## spring boot 3.x导入maven坐标

```groovy
api(
[group: 'com.bbossgroups', name: 'bboss-spring-boot3-starter', version: '6.3.3', transitive: true],
 )
```



# 版本构建方法

gradle clean publishToMavenLocal

需要通过gradle构建发布版本,gradle安装配置参考文档：

https://esdoc.bbossgroups.com/#/bboss-build


配置样例：

```properties
## http服务配置
#spring.bboss.default.http.name=default
#spring.bboss.default.http.timeoutConnection = 5000
#spring.bboss.default.http.timeoutSocket = 5000
#spring.bboss.default.http.connectionRequestTimeout=5000
#spring.bboss.default.http.retryTime = 1
#spring.bboss.default.http.maxLineLength = -1
#spring.bboss.default.http.maxHeaderCount = 200
#spring.bboss.default.http.maxTotal = 400
#spring.bboss.default.http.defaultMaxPerRoute = 200
#spring.bboss.default.http.soReuseAddress = false
#spring.bboss.default.http.soKeepAlive = false
#spring.bboss.default.http.timeToLive = 3600000
#spring.bboss.default.http.keepAlive = 3600000
#spring.bboss.default.http.keystore =
#spring.bboss.default.http.keyPassword =
## ssl 主机名称校验，是否采用default配置，
## 如果指定为default，就采用DefaultHostnameVerifier,否则采用 SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER
#spring.bboss.default.http.hostnameVerifier =
##每隔多少毫秒校验空闲connection，自动释放无效链接
## -1 或者0不检查
#spring.bboss.default.http.validateAfterInactivity=2000
## 每次获取connection时校验连接，true，校验，false不校验，有性能开销，推荐采用
## validateAfterInactivity来控制连接是否有效
## 默认值false
#spring.bboss.default.http.staleConnectionCheckEnabled=false
##* 自定义重试控制接口，必须实现接口方法
##* public interface CustomHttpRequestRetryHandler  {
##* 	public boolean retryRequest(IOException exception, int executionCount, HttpContext context,ClientConfiguration configuration);
##* }
##* 方法返回true，进行重试，false不重试
#spring.bboss.default.http.customHttpRequestRetryHandler=org.frameworkset.spi.remote.http.ConnectionResetHttpRequestRetryHandler
#
## 服务代理配置
## 服务全认证账号配置
#
#spring.bboss.default.http.authAccount=elastic
#spring.bboss.default.http.authPassword=changeme
## ha proxy 集群负载均衡地址配置
##spring.bboss.default.http.hosts=192.168.137.1:808,192.168.137.1:809,192.168.137.1:810
#spring.bboss.default.http.hosts=localhost:8082
## 健康检查服务
#spring.bboss.default.http.health=/
#spring.bboss.default.http.healthCheckInterval=1000
## 服务地址自动发现功能
##spring.bboss.default.http.discoverService.serviceClass=com.test.DiscoverService
## 定时运行服务发现方法时间间隔，单位：毫秒，默认10秒
#spring.bboss.default.http.discoverService.interval=10000
#
## handleNullOrEmptyHostsByDiscovery
##false，忽略对返回的null或者空的hosts进行处理
##true，要对null或者空的hosts进行处理，这样会导致所有的地址不可用
#spring.bboss.default.http.discoverService.handleNullOrEmptyHostsByDiscovery=false

# 数据库数据源配置
spring.bboss.default.db.name = firstds
spring.bboss.default.db.user = root
spring.bboss.default.db.password = 123456
spring.bboss.default.db.driver = com.mysql.jdbc.Driver
spring.bboss.default.db.url = jdbc:mysql://127.0.0.1:3306/apm
spring.bboss.default.db.usePool = true
spring.bboss.default.db.validateSQL = select 1
spring.bboss.default.db.showsql = true




##second es client http服务配置
#spring.bboss.second.http.name=second
#spring.bboss.second.http.timeoutConnection = 5000
#spring.bboss.second.http.timeoutSocket = 5000
#spring.bboss.second.http.connectionRequestTimeout=5000
#spring.bboss.second.http.retryTime = 1
#spring.bboss.second.http.maxLineLength = -1
#spring.bboss.second.http.maxHeaderCount = 200
#spring.bboss.second.http.maxTotal = 400
#spring.bboss.second.http.secondMaxPerRoute = 200
#spring.bboss.second.http.soReuseAddress = false
#spring.bboss.second.http.soKeepAlive = false
#spring.bboss.second.http.timeToLive = 3600000
#spring.bboss.second.http.keepAlive = 3600000
#spring.bboss.second.http.keystore =
#spring.bboss.second.http.keyPassword =
## ssl 主机名称校验，是否采用second配置，
## 如果指定为second，就采用secondHostnameVerifier,否则采用 SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER
#spring.bboss.second.http.hostnameVerifier =
##每隔多少毫秒校验空闲connection，自动释放无效链接
## -1 或者0不检查
#spring.bboss.second.http.validateAfterInactivity=2000
## 每次获取connection时校验连接，true，校验，false不校验，有性能开销，推荐采用
## validateAfterInactivity来控制连接是否有效
## 默认值false
#spring.bboss.second.http.staleConnectionCheckEnabled=false
##* 自定义重试控制接口，必须实现接口方法
##* public interface CustomHttpRequestRetryHandler  {
##* 	public boolean retryRequest(IOException exception, int executionCount, HttpContext context,ClientConfiguration configuration);
##* }
##* 方法返回true，进行重试，false不重试
#spring.bboss.second.http.customHttpRequestRetryHandler=org.frameworkset.spi.remote.http.ConnectionResetHttpRequestRetryHandler
#
## 服务代理配置
## 服务全认证账号配置
#
#spring.bboss.second.http.authAccount=elastic
#spring.bboss.second.http.authPassword=changeme
## ha proxy 集群负载均衡地址配置
##spring.bboss.second.http.hosts=192.168.137.1:808,192.168.137.1:809,192.168.137.1:810
#spring.bboss.second.http.hosts=localhost:8082
## 健康检查服务
#spring.bboss.second.http.health=/
#spring.bboss.second.http.healthCheckInterval=1000
## 服务地址自动发现功能
##spring.bboss.second.http.discoverService.serviceClass=com.test.DiscoverService
## 定时运行服务发现方法时间间隔，单位：毫秒，默认10秒
#spring.bboss.second.http.discoverService.interval=10000
#
## handleNullOrEmptyHostsByDiscovery
##false，忽略对返回的null或者空的hosts进行处理
##true，要对null或者空的hosts进行处理，这样会导致所有的地址不可用
#spring.bboss.second.http.discoverService.handleNullOrEmptyHostsByDiscovery=false

# 数据库数据源配置
spring.bboss.second.db.name = secondds
spring.bboss.second.db.user = root
spring.bboss.second.db.password = 123456
spring.bboss.second.db.driver = com.mysql.jdbc.Driver
spring.bboss.second.db.url = jdbc:mysql://192.168.137.1:3306/bboss
spring.bboss.second.db.usePool = true
spring.bboss.second.db.validateSQL = select 1
```

java 代码：

```java
package com.frameworkset.sqlexecutor;
/*
 *  Copyright 2008 biaoping.yin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import org.frameworkset.spi.boot.BBossStarter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 配置和加载多个db实例,在application.yml配置文件中定义了两个集群default和logs
 * spring.bboss.default
 * spring.bboss.second
 */

@Configuration
public class MultiSTartConfigurer {
	@Primary
	@Bean(name="bbossStarterDefault",initMethod = "start")
	@ConfigurationProperties("spring.bboss.default")

	public BBossStarter bbossStarterDefault(){
		return new BBossStarter();

	}

	@Bean(name="bbossStarterSecond",initMethod = "start")
	@ConfigurationProperties("spring.bboss.second")
	public BBossStarter bbossStarterSecond(){
		return new BBossStarter();
	}
}

```

```java
public class Db2DBdemo implements InitializingBean {
   @Autowired
   @Qualifier("bbossStarterDefault")
   private BBossStarter bbossStarterDefault;
   @Autowired
   @Qualifier("bbossStarterSecond")
   private BBossStarter bbossStarterSecond;
   public void query(){
       SQLExecutor.updateWithDBName("second","drop table scan_boce");
       
       HttpRequestUtil.sendJsonBody("{\"id\":\"15284b36-3404-4bf8-8f14-c2114f2d97fb\",\"data\":\"国产j2ee框架 bboss\"}","http://localhost:9096/xmlrequest/xml/echohttpjson.page")
   }
}
```

jdk要求： jdk 1.8+



## License

The BBoss Framework is released under version 2.0 of the [Apache License][].

[Apache License]: http://www.apache.org/licenses/LICENSE-2.0


# Star History

[![Star History Chart](https://api.star-history.com/svg?repos=bbossgroups/bboss-spring-boot-starter&type=Date)](https://star-history.com/#bbossgroups/bboss-spring-boot-starter&Date)

