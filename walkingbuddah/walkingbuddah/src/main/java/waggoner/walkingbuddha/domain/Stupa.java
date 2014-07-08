package waggoner.walkingbuddha.domain;
import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

/**
 * Created by transapps on 7/7/14.
 */
public class Stupa {
	@SerializedName("name")
	private String name;
	@SerializedName("lat")
	private String lat;
	@SerializedName("lon")
	private String lon;
	@SerializedName("type")
	private String type;
	@SerializedName("desc")
	private String desc;

	public Stupa() {}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getLat() {
		return lat;
	}

	public String getLon() {
		return lon;
	}

	public String getType() {
		return type;
	}

	public String getDesc() {
		return desc;
	}

}
