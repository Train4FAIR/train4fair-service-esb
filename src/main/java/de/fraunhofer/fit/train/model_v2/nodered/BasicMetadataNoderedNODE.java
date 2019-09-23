package de.fraunhofer.fit.train.model_v2.nodered;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasicMetadataNoderedNODE {
	
	
	@Id
	private ObjectId _id;
	
	@SerializedName("internalId")
	@Expose
	private String internalId;

	@SerializedName("internalVersion")
	@Expose
	private String internalVersion;

	@SerializedName("internalPointer")
	@Expose
	private String internalPointer;
	
	@SerializedName("wires")
	@Expose
	private String[][] wires;


	@SerializedName("_wire")
	@Expose
	private String _wire;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("z")
	@Expose
	private String z;

	@SerializedName("id")
	@Expose
	private String id;


	@SerializedName("type")
	@Expose
	private String type;
	
	
	@SerializedName("_wireCount")
	@Expose
	private String _wireCount;
	


	@SerializedName("parentWireId")
	@Expose
	private String[] parentWireId;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String[][] getWires() {
		return wires;
	}

	public void setWires(String[][] wires) {
		this.wires = wires;
	}


	public String get_wire() {
		return _wire;
	}

	public void set_wire(String _wire) {
		this._wire = _wire;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZ() {
		return z;
	}

	public void setZ(String z) {
		this.z = z;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String get_wireCount() {
		return _wireCount;
	}

	public void set_wireCount(String _wireCount) {
		this._wireCount = _wireCount;
	}


	public String getInternalId() {
		return internalId;
	}

	public void setInternalId(String internalId) {
		this.internalId = internalId;
	}

	public String getInternalVersion() {
		return internalVersion;
	}

	public void setInternalVersion(String internalVersion) {
		this.internalVersion = internalVersion;
	}

	public String getInternalPointer() {
		return internalPointer;
	}

	public void setInternalPointer(String internalPointer) {
		this.internalPointer = internalPointer;
	}

	public String[] getParentWireId() {
		return parentWireId;
	}

	public void setParentWireId(String[] parentWireId) {
		this.parentWireId = parentWireId;
	}
	

	

}
