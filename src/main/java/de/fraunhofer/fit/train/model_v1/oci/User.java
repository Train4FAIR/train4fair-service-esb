package de.fraunhofer.fit.train.model_v1.oci;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@Deprecated
@XStreamAlias("User")
@Repository
@Document(collection = "user")
public class User {
	
	@XStreamAsAttribute
	@XStreamAlias("user")
	@SerializedName("user")
	@Expose
	private String user;
	
	@XStreamAsAttribute
	@XStreamAlias("pass")
	@SerializedName("pass")
	@Expose
	private String pass;
	
	@XStreamAsAttribute
	@XStreamAlias("token")
	@SerializedName("token")
	@Expose
	private String token;
	
	
	@XStreamAsAttribute
	@XStreamAlias("privateKey")
	@SerializedName("privateKey")
	@Expose
	private String privateKey;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	
	

}
