package org.frameworkset.spi.boot;/*
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

import com.frameworkset.common.poolman.ConfigSQLExecutor;
import com.frameworkset.common.poolman.util.DBConf;
import com.frameworkset.common.poolman.util.SQLManager;
import org.frameworkset.spi.assemble.PropertiesContainer;
import org.frameworkset.spi.assemble.PropertiesInterceptor;
import org.frameworkset.spi.assemble.PropertyContext;
import org.frameworkset.spi.remote.http.ClientConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * bboss spring boot starter配置，目前支持:
 * spring.bboss.db 数据库连接池配置
 * spring.bboss.http  http连接池和http proxy配置
 *
 */
public class BBossStarter extends BaseBBossProperties{
	@Autowired
	private BBossProperties properties;
	private static final Logger log = LoggerFactory.getLogger(BBossStarter.class);
	public void start() {

		/**
		 * 启动数据源
		 * //数据源相关配置，可选项，可以在外部启动数据源
		 * 					importBuilder.setDbName("test")
		 * 							.setDbDriver("com.mysql.cj.jdbc.Driver") //数据库驱动程序，必须导入相关数据库的驱动jar包
		 * 							//mysql stream机制一 通过useCursorFetch=true启用mysql的游标fetch机制，否则会有严重的性能隐患，useCursorFetch必须和jdbcFetchSize参数配合使用，否则不会生效
		 * //					.setDbUrl("jdbc:mysql://localhost:3306/bboss?useCursorFetch=true&useUnicode=true&characterEncoding=utf-8&useSSL=false")
		 * //					.setJdbcFetchSize(3000)//启用mysql stream机制1，设置jdbcfetchsize大小为3000
		 * 							//mysql stream机制二  jdbcFetchSize为Integer.MIN_VALUE即可，url中不需要设置useCursorFetch=true参数，这里我们使用机制二
		 * 							.setDbUrl("jdbc:mysql://localhost:3306/bboss?useUnicode=true&characterEncoding=utf-8&useSSL=false")
		 * 							.setJdbcFetchSize(Integer.MIN_VALUE)//启用mysql stream机制二,设置jdbcfetchsize大小为Integer.MIN_VALUE
		 * 							.setDbUser("root")
		 * 							.setDbPassword("123456")
		 * 							.setValidateSQL("select 1")
		 * 							.setUsePool(false);//是否使用连接池
		 */
		initHttp();
		initDs();

	}

	private void initDs(){
		String temp = null;
		if(this.propertiesInterceptor == null){
			temp = properties.getPropertiesInterceptor();
		}
		else{
			temp = propertiesInterceptor;
		}
		if(temp != null && !temp.trim().equals("")){
			temp = temp.trim();

		}
		if(this.getDb() == null ){
			if(  properties.getDb() != null && properties.getDb().getUrl() != null){
				try {
					Class clz = Class.forName(temp);
					PropertiesInterceptor propertiesInterceptor = (PropertiesInterceptor) clz.newInstance();
					PropertyContext propertyContext = new PropertyContext();
					propertyContext.setValue(properties.getDb());
					propertiesInterceptor.convert(propertyContext);
				}
				catch (Exception e){
					log.error("Init Ds "+temp,e);
				}
				initDS(properties.getDb());
			}
		}
		else{
			if(getDb().getUrl() != null) {
				try {
					Class clz = Class.forName(temp);
					PropertiesInterceptor propertiesInterceptor = (PropertiesInterceptor) clz.newInstance();
					PropertyContext propertyContext = new PropertyContext();
					propertyContext.setValue(getDb());
					propertiesInterceptor.convert(propertyContext);
				}
				catch (Exception e){
					log.error("Init Ds "+temp,e);
				}
				initDS(getDb());
			}
		}
	}
	private PropertiesContainer initHttp(){
		PropertiesContainer propertiesContainer = null;
		if(this.getHttp() == null){
			if(this.properties.getHttp() != null){
				Map<String,String> properties = this.properties.buildProperties();
				propertiesContainer = new PropertiesContainer();
				propertiesContainer.addAll(properties);
				String[] httpNames = this.properties.getHttp().getName() != null?new String[]{this.properties.getHttp().getName()}:new String[]{"default"};
				//初始化Http连接池
				ClientConfiguration.bootClientConfiguations(httpNames, propertiesContainer);
			}
		}
		else{
			Map<String,String> properties = this.buildProperties();
			propertiesContainer = new PropertiesContainer();
			propertiesContainer.addAll(properties);
			String[] httpNames = this.getHttp().getName() != null?new String[]{this.getHttp().getName()}:new String[]{"default"};
			//初始化Http连接池
			ClientConfiguration.bootClientConfiguations(httpNames, propertiesContainer);
		}
		return propertiesContainer;
	}
	private void initDS(Db db){
		DBConf temConf = new DBConf();
		temConf.setPoolname(db.getName());
		temConf.setDriver(db.getDriver());
		temConf.setJdbcurl(db.getUrl());
		temConf.setUsername(db.getUser());
		temConf.setPassword(db.getPassword());
		temConf.setReadOnly(null);
		temConf.setTxIsolationLevel(null);
		temConf.setValidationQuery(db.getValidateSQL());
		temConf.setJndiName(db.getName()+"_jndi");
		temConf.setInitialConnections(db.getInitSize() != null?Integer.parseInt(db.getInitSize()):10);
		temConf.setMinimumSize(db.getMinIdleSize() != null?Integer.parseInt(db.getMinIdleSize()):10);
		temConf.setMaximumSize(db.getMaxSize() != null?Integer.parseInt(db.getMaxSize()):50);
		temConf.setUsepool(db.getUsePool() != null?Boolean.parseBoolean(db.getUsePool()):true);
		temConf.setExternal(false);
		temConf.setExternaljndiName(null);
		temConf.setShowsql(db.getShowSql()!= null?Boolean.parseBoolean(db.getShowSql()):true);
		temConf.setEncryptdbinfo(false);
		temConf.setQueryfetchsize(db.getJdbcFetchSize() != null?Integer.parseInt(db.getJdbcFetchSize()):null);
		temConf.setDbAdaptor(db.getDbAdaptor());
		temConf.setDbtype(db.getDbtype());
		boolean ff = db.getColumnLableUpperCase() == null ? true:db.getColumnLableUpperCase().equals("true");
		temConf.setColumnLableUpperCase(ff);
		SQLManager.startPool(temConf);
		/**
		SQLUtil.startPool(db.getName(),//数据源名称
				db.getDriver(),//jdbc驱动
				db.getUrl(),//mysql链接串
				db.getUser(), db.getPassword(),//数据库账号和口令
				null,//"false",
				null,// "READ_UNCOMMITTED",
				db.getValidateSQL(),//数据库连接校验sql
				db.getName()+"_jndi",
				db.getInitSize() != null?Integer.parseInt(db.getInitSize()):10,
				db.getMinIdleSize() != null?Integer.parseInt(db.getMinIdleSize()):10,
				db.getMaxSize() != null?Integer.parseInt(db.getMaxSize()):50,
				db.getUsePool() != null?Boolean.parseBoolean(db.getUsePool()):true,
				false,
				null, db.getShowSql()!= null?Boolean.parseBoolean(db.getShowSql()):true, false,
				db.getJdbcFetchSize() != null?Integer.parseInt(db.getInitSize()):0,
				db.getDbtype(),db.getDbAdaptor()
		);*/
	}



	/**
	 * Get default elasticsearch server ConfigFile ClientInterface
	 * @param configFile
	 * @return
	 */
	public ConfigSQLExecutor getConfigRestClient(String configFile){
		ConfigSQLExecutor configSQLExecutor = new ConfigSQLExecutor(configFile);
		return configSQLExecutor;

	}


}
