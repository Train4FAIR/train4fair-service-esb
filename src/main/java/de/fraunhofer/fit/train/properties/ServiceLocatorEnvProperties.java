package de.fraunhofer.fit.train.properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class ServiceLocatorEnvProperties {

	@Value("${srv_loc_protocol}")
	private String protocol;

	@Value("${srv_loc_host}")
	private String host;

	@Value("${srv_loc_port}")
	private String port;

	@Value("${srv_loc_app_ctx}")
	private String appContext;

	@Value("${srv_loc_rest_ctx}")
	private String serviceContext;

	@Value("${app_env}")
	private String loadDb;
	
	@Value("${load_db}")
	private String appEnv;
	
	@Value("${env_db_name}")
	private String envDbName;
	
	@Value("${env_db_type}")
	private String envDbType;
	
	@Value("${env_db_token}")
	private String envDBToken;
	
	@Value("${env_ms_name}")
	private String envMsName;
	
	@Value("${env_ms_type}")
	private String envMsType;
	
	@Value("${env_ms_token}")
	private String envMsToken;
	
	@Value("${env_dav_name}")
	private String envDavName;
	
	@Value("${env_dav_type}")
	private String envDavType;
	
	@Value("${env_dav_token}")
	private String envDavToken;

	
	
	
	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getAppContext() {
		return appContext;
	}

	public void setAppContext(String appContext) {
		this.appContext = appContext;
	}

	public String getServiceContext() {
		return serviceContext;
	}

	public void setServiceContext(String serviceContext) {
		this.serviceContext = serviceContext;
	}

	public String getLoadDb() {
		return loadDb;
	}

	public void setLoadDb(String loadDb) {
		this.loadDb = loadDb;
	}

	public String getAppEnv() {
		return appEnv;
	}

	public void setAppEnv(String appEnv) {
		this.appEnv = appEnv;
	}

	public String getEnvDbName() {
		return envDbName;
	}

	public void setEnvDbName(String envDbName) {
		this.envDbName = envDbName;
	}

	public String getEnvDbType() {
		return envDbType;
	}

	public void setEnvDbType(String envDbType) {
		this.envDbType = envDbType;
	}

	
	public String getEnvDBToken() {
		return envDBToken;
	}

	public void setEnvDBToken(String envDBToken) {
		this.envDBToken = envDBToken;
	}

	public String getEnvMsName() {
		return envMsName;
	}

	public void setEnvMsName(String envMsName) {
		this.envMsName = envMsName;
	}

	public String getEnvMsType() {
		return envMsType;
	}

	public void setEnvMsType(String envMsType) {
		this.envMsType = envMsType;
	}

	public String getEnvMsToken() {
		return envMsToken;
	}

	public void setEnvMsToken(String envMsToken) {
		this.envMsToken = envMsToken;
	}

	public String getEnvDavName() {
		return envDavName;
	}

	public void setEnvDavName(String envDavName) {
		this.envDavName = envDavName;
	}

	public String getEnvDavType() {
		return envDavType;
	}

	public void setEnvDavType(String envDavType) {
		this.envDavType = envDavType;
	}

	public String getEnvDavToken() {
		return envDavToken;
	}

	public void setEnvDavToken(String envDavToken) {
		this.envDavToken = envDavToken;
	}

	@PostConstruct
	public void print() {
		System.out.println(this.serviceContext);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
