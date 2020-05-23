package org.frameworkset.spi.boot;
/*
 *  Copyright 2020 biaoping.yin
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

import com.frameworkset.util.SimpleStringUtil;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseBBossProperties {
	private Db db;
	private Http http;

	 

	public Db getDb() {
		return db;
	}

	public void setDb(Db db) {
		this.db = db;
	}

	public Http getHttp() {
		return http;
	}

	public void setHttp(Http http) {
		this.http = http;
	}


	public static class Db{
		private String name;
		private String user;
		private String password;
		private String driver;
		private String url;
		private String usePool;
		private String validateSQL;
		private String maxSize;
		private String minIdleSize;
		private String initSize;
		private String showSql;
		private String dbtype;
		private String dbAdaptor;
		private String jdbcFetchSize;
		private String datasources;
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getDriver() {
			return driver;
		}

		public void setDriver(String driver) {
			this.driver = driver;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getUsePool() {
			return usePool;
		}

		public void setUsePool(String usePool) {
			this.usePool = usePool;
		}

		public String getValidateSQL() {
			return validateSQL;
		}

		public void setValidateSQL(String validateSQL) {
			this.validateSQL = validateSQL;
		}


		public String getMaxSize() {
			return maxSize;
		}

		public void setMaxSize(String maxSize) {
			this.maxSize = maxSize;
		}




		public String getInitSize() {
			return initSize;
		}

		public void setInitSize(String initSize) {
			this.initSize = initSize;
		}

		public String getShowSql() {
			return showSql;
		}

		public void setShowSql(String showSql) {
			this.showSql = showSql;
		}

		public String getDbtype() {
			return dbtype;
		}

		public void setDbtype(String dbtype) {
			this.dbtype = dbtype;
		}

		public String getDbAdaptor() {
			return dbAdaptor;
		}

		public void setDbAdaptor(String dbAdaptor) {
			this.dbAdaptor = dbAdaptor;
		}

		public String getJdbcFetchSize() {
			return jdbcFetchSize;
		}

		public void setJdbcFetchSize(String jdbcFetchSize) {
			this.jdbcFetchSize = jdbcFetchSize;
		}

		public String getMinIdleSize() {
			return minIdleSize;
		}

		public void setMinIdleSize(String minIdleSize) {
			this.minIdleSize = minIdleSize;
		}

		public String getDatasources() {
			return datasources;
		}

		public void setDatasources(String datasources) {
			this.datasources = datasources;
		}
	}
	public static class DiscoverService{
		private String serviceClass;
		private String interval;
		private String handleNullOrEmptyHostsByDiscovery;



		public String getInterval() {
			return interval;
		}

		public void setInterval(String interval) {
			this.interval = interval;
		}

		public String getHandleNullOrEmptyHostsByDiscovery() {
			return handleNullOrEmptyHostsByDiscovery;
		}

		public void setHandleNullOrEmptyHostsByDiscovery(String handleNullOrEmptyHostsByDiscovery) {
			this.handleNullOrEmptyHostsByDiscovery = handleNullOrEmptyHostsByDiscovery;
		}

		public String getServiceClass() {
			return serviceClass;
		}

		public void setServiceClass(String serviceClass) {
			this.serviceClass = serviceClass;
		}
	}
	public static class Http{
		private String name;
		private String keystore;
		private String keyPassword;
		private String hostnameVerifier;
		private String timeoutConnection;
		private String timeoutSocket;
		private String connectionRequestTimeout;
		private String automaticRetriesDisabled;
		private String retryTime;
		private String backoffAuth;
		private String retryInterval;
		private String maxLineLength;
		private String maxHeaderCount;
		private String maxTotal;
		private String defaultMaxPerRoute;
		private String soReuseAddress;
		private String soKeepAlive;
		private String timeToLive;
		private String validateAfterInactivity;
		private String keystoreAlias;
		private String trustAlias;
		private String supportedProtocols;
		private String truststore;
		private String trustPassword;
		private String httpClientBuilderCallback;
		/**
		 * 每次获取connection时校验连接，true，校验，false不校验，有性能开销，推荐采用
		 * validateAfterInactivity来控制连接是否有效
		 * 默认值false
		 */
		private String staleConnectionCheckEnabled = "false";


		/**
		 *
		 * # 服务代理配置
		 * # 服务全认证账号配置
		 * http.authAccount=elastic
		 * http.authPassword=changeme
		 * # ha proxy 集群负载均衡地址配置
		 * http.hosts=192.168.137.1:808,192.168.137.1:809,192.168.137.1:810
		 * # 健康检查服务
		 * http.health=/health
		 * # 服务地址自动发现功能
		 * #http.discoverService=com.test.DiscoverService
		 * # 定时运行服务发现方法时间间隔，单位：毫秒，默认10秒
		 * http.discoverService.interval=10000
		 *
		 * # handleNullOrEmptyHostsByDiscovery
		 * #false，忽略对返回的null或者空的hosts进行处理
		 * #true，要对null或者空的hosts进行处理，这样会导致所有的地址不可用
		 * http.discoverService.handleNullOrEmptyHostsByDiscovery=false
		 * 参考文档：
		 * https://esdoc.bbossgroups.com/#/httpproxy
		 */
		private String authAccount;
		private String authPassword;
		private String hosts;
		private String health;
		private String routing;
		private String healthCheckInterval;
		private DiscoverService discoverService;

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public String getEvictExpiredConnections() {
			return evictExpiredConnections;
		}

		public void setEvictExpiredConnections(String evictExpiredConnections) {
			this.evictExpiredConnections = evictExpiredConnections;
		}

		private String evictExpiredConnections = "true";
		/**
		 * 自定义重试控制接口，必须实现接口方法
		 * public interface CustomHttpRequestRetryHandler  {
		 * 	public boolean retryRequest(IOException exception, int executionCount, HttpContext context,ClientConfiguration configuration);
		 * }
		 * 方法返回true，进行重试，false不重试
		 */
		private String customHttpRequestRetryHandler;

		public String getTimeoutConnection() {
			return timeoutConnection;
		}

		public void setTimeoutConnection(String timeoutConnection) {
			this.timeoutConnection = timeoutConnection;
		}

		public String getTimeoutSocket() {
			return timeoutSocket;
		}

		public void setTimeoutSocket(String timeoutSocket) {
			this.timeoutSocket = timeoutSocket;
		}

		public String getConnectionRequestTimeout() {
			return connectionRequestTimeout;
		}

		public void setConnectionRequestTimeout(String connectionRequestTimeout) {
			this.connectionRequestTimeout = connectionRequestTimeout;
		}

		public String getRetryTime() {
			return retryTime;
		}

		public void setRetryTime(String retryTime) {
			this.retryTime = retryTime;
		}

		public String getMaxLineLength() {
			return maxLineLength;
		}

		public void setMaxLineLength(String maxLineLength) {
			this.maxLineLength = maxLineLength;
		}

		public String getMaxHeaderCount() {
			return maxHeaderCount;
		}

		public void setMaxHeaderCount(String maxHeaderCount) {
			this.maxHeaderCount = maxHeaderCount;
		}

		public String getMaxTotal() {
			return maxTotal;
		}

		public void setMaxTotal(String maxTotal) {
			this.maxTotal = maxTotal;
		}

		public String getDefaultMaxPerRoute() {
			return defaultMaxPerRoute;
		}

		public void setDefaultMaxPerRoute(String defaultMaxPerRoute) {
			this.defaultMaxPerRoute = defaultMaxPerRoute;
		}

		public String getSoReuseAddress() {
			return soReuseAddress;
		}

		public void setSoReuseAddress(String soReuseAddress) {
			this.soReuseAddress = soReuseAddress;
		}

		public String getSoKeepAlive() {
			return soKeepAlive;
		}

		public void setSoKeepAlive(String soKeepAlive) {
			this.soKeepAlive = soKeepAlive;
		}

		public String getTimeToLive() {
			return timeToLive;
		}

		public void setTimeToLive(String timeToLive) {
			this.timeToLive = timeToLive;
		}

		public String getKeepAlive() {
			return keepAlive;
		}

		public void setKeepAlive(String keepAlive) {
			this.keepAlive = keepAlive;
		}

		private String keepAlive;



		public String getKeystore() {
			return keystore;
		}

		public void setKeystore(String keystore) {
			this.keystore = keystore;
		}

		public String getKeyPassword() {
			return keyPassword;
		}

		public void setKeyPassword(String keyPassword) {
			this.keyPassword = keyPassword;
		}

		public String getHostnameVerifier() {
			return hostnameVerifier;
		}

		public void setHostnameVerifier(String hostnameVerifier) {
			this.hostnameVerifier = hostnameVerifier;
		}


		public String getValidateAfterInactivity() {
			return validateAfterInactivity;
		}

		public void setValidateAfterInactivity(String validateAfterInactivity) {
			this.validateAfterInactivity = validateAfterInactivity;
		}

		public String getCustomHttpRequestRetryHandler() {
			return customHttpRequestRetryHandler;
		}

		public void setCustomHttpRequestRetryHandler(String customHttpRequestRetryHandler) {
			this.customHttpRequestRetryHandler = customHttpRequestRetryHandler;
		}

		public String isStaleConnectionCheckEnabled() {
			return staleConnectionCheckEnabled;
		}

		public void setStaleConnectionCheckEnabled(String staleConnectionCheckEnabled) {
			this.staleConnectionCheckEnabled = staleConnectionCheckEnabled;
		}

		public String getRetryInterval() {
			return retryInterval;
		}

		public void setRetryInterval(String retryInterval) {
			this.retryInterval = retryInterval;
		}

		public String getKeystoreAlias() {
			return keystoreAlias;
		}

		public void setKeystoreAlias(String keystoreAlias) {
			this.keystoreAlias = keystoreAlias;
		}

		public String getTrustAlias() {
			return trustAlias;
		}

		public void setTrustAlias(String trustAlias) {
			this.trustAlias = trustAlias;
		}

		public String getSupportedProtocols() {
			return supportedProtocols;
		}

		public void setSupportedProtocols(String supportedProtocols) {
			this.supportedProtocols = supportedProtocols;
		}

		public String getTruststore() {
			return truststore;
		}

		public void setTruststore(String truststore) {
			this.truststore = truststore;
		}

		public String getTrustPassword() {
			return trustPassword;
		}

		public void setTrustPassword(String trustPassword) {
			this.trustPassword = trustPassword;
		}

		public String getAutomaticRetriesDisabled() {
			return automaticRetriesDisabled;
		}

		public void setAutomaticRetriesDisabled(String automaticRetriesDisabled) {
			this.automaticRetriesDisabled = automaticRetriesDisabled;
		}

		public String getAuthAccount() {
			return authAccount;
		}

		public void setAuthAccount(String authAccount) {
			this.authAccount = authAccount;
		}

		public String getAuthPassword() {
			return authPassword;
		}

		public void setAuthPassword(String authPassword) {
			this.authPassword = authPassword;
		}

		public String getHosts() {
			return hosts;
		}

		public void setHosts(String hosts) {
			this.hosts = hosts;
		}

		public String getHealth() {
			return health;
		}

		public void setHealth(String health) {
			this.health = health;
		}

		public DiscoverService getDiscoverService() {
			return discoverService;
		}

		public void setDiscoverService(DiscoverService discoverService) {
			this.discoverService = discoverService;
		}

		public String getRouting() {
			return routing;
		}

		public void setRouting(String routing) {
			this.routing = routing;
		}

		public String getHealthCheckInterval() {
			return healthCheckInterval;
		}

		public void setHealthCheckInterval(String healthCheckInterval) {
			this.healthCheckInterval = healthCheckInterval;
		}

		public String getHttpClientBuilderCallback() {
			return httpClientBuilderCallback;
		}

		public void setHttpClientBuilderCallback(String httpClientBuilderCallback) {
			this.httpClientBuilderCallback = httpClientBuilderCallback;
		}

		public String getBackoffAuth() {
			return backoffAuth;
		}

		public void setBackoffAuth(String backoffAuth) {
			this.backoffAuth = backoffAuth;
		}
	}



	/**
	 * ##default集群配配置
	 * elasticUser=elastic
	 * elasticPassword=changeme
	 *
	 * #elasticsearch.rest.hostNames=10.1.236.88:9200
	 * #elasticsearch.rest.hostNames=127.0.0.1:9200
	 * #elasticsearch.rest.hostNames=10.21.20.168:9200
	 * elasticsearch.rest.hostNames=127.0.0.1:9200
	 * #elasticsearch.rest.hostNames=10.180.211.27:9280,10.180.211.27:9281,10.180.211.27:9282
	 * elasticsearch.dateFormat=yyyy.MM.dd
	 * elasticsearch.timeZone=Asia/Shanghai
	 * elasticsearch.ttl=2d
	 * #在控制台输出脚本调试开关showTemplate,false关闭，true打开，同时log4j至少是info级别
	 * elasticsearch.showTemplate=true
	 * elasticsearch.discoverHost=false
	 *
	 * ##default连接池配置
	 * http.timeoutConnection = 400000
	 * http.timeoutSocket = 400000
	 * http.connectionRequestTimeout=400000
	 * http.retryTime = 1
	 * http.maxLineLength = -1
	 * http.maxHeaderCount = 200
	 * http.maxTotal = 400
	 * http.defaultMaxPerRoute = 200
	 * http.soReuseAddress = false
	 * http.soKeepAlive = false
	 * http.timeToLive = 3600000
	 * http.keepAlive = 3600000
	 * http.keystore =
	 * http.keyPassword =
	 * # ssl 主机名称校验，是否采用default配置，
	 * # 如果指定为default，就采用DefaultHostnameVerifier,否则采用 SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER
	 * http.hostnameVerifier =
	 *
	 * # dsl配置文件热加载扫描时间间隔，毫秒为单位，默认5秒扫描一次，<= 0时关闭扫描机制
	 * dslfile.refreshInterval = -1
	 *
	 *
	 * # 演示数据库数据导入elasticsearch源配置
	 * db.name = test
	 * db.user = root
	 * db.password = 123456
	 * db.driver = com.mysql.jdbc.Driver
	 * db.url = jdbc:mysql://localhost:3306/bboss
	 * db.usePool = false
	 * db.validateSQL = select 1
	 * @return
	 */

	public Map buildProperties(){
		Map properties = new HashMap();
		String name = this.getHttp().getName() != null? this.getHttp().getName()+".":"default.";



		//##http连接池配置
		if(this.getHttp() != null){
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getTimeoutConnection()))
				properties.put(name + "http.timeoutConnection",this.getHttp().getTimeoutConnection());

			if(SimpleStringUtil.isNotEmpty(this.getHttp().getTimeoutSocket()))
				properties.put(name + "http.timeoutSocket",this.getHttp().getTimeoutSocket());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getConnectionRequestTimeout()))
				properties.put(name + "http.connectionRequestTimeout",this.getHttp().getConnectionRequestTimeout());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getAutomaticRetriesDisabled()))
				properties.put(name + "http.automaticRetriesDisabled",this.getHttp().getAutomaticRetriesDisabled());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getBackoffAuth()))
				properties.put(name+"http.backoffAuth",this.getHttp().getBackoffAuth());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getRetryTime()))
				properties.put(name + "http.retryTime",this.getHttp().getRetryTime());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getRetryInterval()))
				properties.put(name + "http.retryInterval",this.getHttp().getRetryInterval());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getMaxLineLength()))
				properties.put(name + "http.maxLineLength",this.getHttp().getMaxLineLength());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getMaxHeaderCount()))
				properties.put(name + "http.maxHeaderCount",this.getHttp().getMaxHeaderCount());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getMaxTotal()))
				properties.put(name + "http.maxTotal",this.getHttp().getMaxTotal());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getDefaultMaxPerRoute()))
				properties.put(name + "http.defaultMaxPerRoute",this.getHttp().getDefaultMaxPerRoute());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getSoReuseAddress()))
				properties.put(name + "http.soReuseAddress",this.getHttp().getSoReuseAddress());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getSoKeepAlive()))
				properties.put(name + "http.soKeepAlive",this.getHttp().getSoKeepAlive());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getTimeToLive()))
				properties.put(name + "http.timeToLive",this.getHttp().getTimeToLive());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getKeepAlive()))
				properties.put(name + "http.keepAlive",this.getHttp().getKeepAlive());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getKeystore()))
				properties.put(name + "http.keystore",this.getHttp().getKeystore());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getKeyPassword()))
				properties.put(name + "http.keyPassword",this.getHttp().getKeyPassword());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getHostnameVerifier()))
				properties.put(name + "http.hostnameVerifier",this.getHttp().getHostnameVerifier());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getValidateAfterInactivity() ))
				properties.put(name + "http.validateAfterInactivity",this.getHttp().getValidateAfterInactivity());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().isStaleConnectionCheckEnabled()))
				properties.put(name + "http.staleConnectionCheckEnabled",this.getHttp().isStaleConnectionCheckEnabled());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getCustomHttpRequestRetryHandler()))
				properties.put(name + "http.customHttpRequestRetryHandler",this.getHttp().getCustomHttpRequestRetryHandler());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getEvictExpiredConnections()))
				properties.put(name + "http.evictExpiredConnections",this.getHttp().getEvictExpiredConnections());

/**
 * keystoreAlias
 * trustAlias
 * supportedProtocols
 * truststore
 * trustPassword
 */
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getKeystoreAlias()))
				properties.put(name + "http.keystoreAlias",this.getHttp().getKeystoreAlias());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getTrustAlias() ))
				properties.put(name + "http.trustAlias",this.getHttp().getTrustAlias());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getSupportedProtocols()))
				properties.put(name + "http.supportedProtocols",this.getHttp().getSupportedProtocols());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getTruststore()))
				properties.put(name + "http.truststore",this.getHttp().getTruststore());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getTrustPassword()))
				properties.put(name + "http.trustPassword",this.getHttp().getTrustPassword());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getHttpClientBuilderCallback()))
				properties.put(name + "http.httpClientBuilderCallback",this.getHttp().getHttpClientBuilderCallback());

			/**
			 *
			 * # 服务代理配置
			 * # 服务全认证账号配置
			 * http.authAccount=elastic
			 * http.authPassword=changeme
			 * # ha proxy 集群负载均衡地址配置
			 * http.hosts=192.168.137.1:808,192.168.137.1:809,192.168.137.1:810
			 * # 健康检查服务
			 * http.health=/health
			 * # 服务地址自动发现功能
			 * #http.discoverService=com.test.DiscoverService
			 * # 定时运行服务发现方法时间间隔，单位：毫秒，默认10秒
			 * http.discoverService.interval=10000
			 *
			 * # handleNullOrEmptyHostsByDiscovery
			 * #false，忽略对返回的null或者空的hosts进行处理
			 * #true，要对null或者空的hosts进行处理，这样会导致所有的地址不可用
			 * http.discoverService.handleNullOrEmptyHostsByDiscovery=false
			 * 参考文档：
			 * https://esdoc.bbossgroups.com/#/httpproxy
			 */
//			private String authAccount;
//			private String authPassword;
//			private String hosts;
//			private String health;
//			private String routing;
//			private DiscoverService discoverService;
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getAuthAccount()))
				properties.put(name + "http.authAccount",this.getHttp().getAuthAccount());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getAuthPassword() ))
				properties.put(name + "http.authPassword",this.getHttp().getAuthPassword());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getHosts()))
				properties.put(name + "http.hosts",this.getHttp().getHosts());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getHealth()))
				properties.put(name + "http.health",this.getHttp().getHealth());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getRouting()))
				properties.put(name + "http.routing",this.getHttp().getRouting());
			if(SimpleStringUtil.isNotEmpty(this.getHttp().getRouting()))
				properties.put(name + "http.healthCheckInterval",this.getHttp().getHealthCheckInterval());

			if(this.getHttp().getDiscoverService()  != null) {
				if (SimpleStringUtil.isNotEmpty(this.getHttp().getDiscoverService().getServiceClass()))
					properties.put(name + "http.discoverService", this.getHttp().getDiscoverService().getServiceClass());
				if (SimpleStringUtil.isNotEmpty(this.getHttp().getDiscoverService().getInterval()))
					properties.put(name + "http.discoverService.interval", this.getHttp().getDiscoverService().getInterval());
				if (SimpleStringUtil.isNotEmpty(this.getHttp().getDiscoverService().getHandleNullOrEmptyHostsByDiscovery()))
					properties.put(name + "http.handleNullOrEmptyHostsByDiscovery", this.getHttp().getDiscoverService().getHandleNullOrEmptyHostsByDiscovery());
			}




		}


		return properties;
	}
}
