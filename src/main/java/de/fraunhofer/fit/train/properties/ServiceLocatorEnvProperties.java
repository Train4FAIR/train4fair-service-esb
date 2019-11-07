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
	
	@Value("${esb_server_address}")
	private String esbServerHost;
	
	@Value("${esb_server_port}")
	private String esbServerPort;
	
	
	@Value("${mongo_host}")
	private String esbDBHost;
	
	@Value("${mongo_port}")
	private String esbDBPort;


	@Value("${env_dav_metadata_name}")
	private String envDavMetadataName;
	
	@Value("${env_dav_metadata_type}")
	private String envDavMetadataType;
	
	@Value("${env_dav_metadata_token}")
	private String envDavMetadataToken;
	
	@Value("${env_dav_doc_name}")
	private String envDavDocumentationName;
	
	@Value("${env_dav_doc_type}")
	private String envDavDocumentationType;
	
	@Value("${env_dav_doc_token}")
	private String envDavDocumentationToken;
	
	@Value("${env_dav_page_name}")
	private String envDavPageName;
	
	@Value("${env_dav_page_type}")
	private String envDavPageType;
	
	@Value("${env_dav_page_token}")
	private String envDavPageToken;
	
	
	
	public String getEnvDavMetadataName() {
		return envDavMetadataName;
	}

	public void setEnvDavMetadataName(String envDavMetadataName) {
		this.envDavMetadataName = envDavMetadataName;
	}

	public String getEnvDavMetadataType() {
		return envDavMetadataType;
	}

	public void setEnvDavMetadataType(String envDavMetadataType) {
		this.envDavMetadataType = envDavMetadataType;
	}

	public String getEnvDavMetadataToken() {
		return envDavMetadataToken;
	}

	public void setEnvDavMetadataToken(String envDavMetadataToken) {
		this.envDavMetadataToken = envDavMetadataToken;
	}

	public String getEnvDavDocumentationName() {
		return envDavDocumentationName;
	}

	public void setEnvDavDocumentationName(String envDavDocumentationName) {
		this.envDavDocumentationName = envDavDocumentationName;
	}

	public String getEnvDavDocumentationType() {
		return envDavDocumentationType;
	}

	public void setEnvDavDocumentationType(String envDavDocumentationType) {
		this.envDavDocumentationType = envDavDocumentationType;
	}

	public String getEnvDavDocumentationToken() {
		return envDavDocumentationToken;
	}

	public void setEnvDavDocumentationToken(String envDavDocumentationToken) {
		this.envDavDocumentationToken = envDavDocumentationToken;
	}

	public String getEnvDavPageName() {
		return envDavPageName;
	}

	public void setEnvDavPageName(String envDavPageName) {
		this.envDavPageName = envDavPageName;
	}

	public String getEnvDavPageType() {
		return envDavPageType;
	}

	public void setEnvDavPageType(String envDavPageType) {
		this.envDavPageType = envDavPageType;
	}

	public String getEnvDavPageToken() {
		return envDavPageToken;
	}

	public void setEnvDavPageToken(String envDavPageToken) {
		this.envDavPageToken = envDavPageToken;
	}

	public String getEsbDBHost() {
		return esbDBHost;
	}

	public void setEsbDBHost(String esbDBHost) {
		this.esbDBHost = esbDBHost;
	}

	public String getEsbDBPort() {
		return esbDBPort;
	}

	public void setEsbDBPort(String esbDBPort) {
		this.esbDBPort = esbDBPort;
	}

	public String getEsbServerHost() {
		return esbServerHost;
	}

	public void setEsbServerHost(String esbServerHost) {
		this.esbServerHost = esbServerHost;
	}

	public String getEsbServerPort() {
		return esbServerPort;
	}

	public void setEsbServerPort(String esbServerPort) {
		this.esbServerPort = esbServerPort;
	}

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
