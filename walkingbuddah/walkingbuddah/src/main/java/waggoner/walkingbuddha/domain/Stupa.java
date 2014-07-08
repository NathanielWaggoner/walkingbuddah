package waggoner.walkingbuddha.domain;

/**
 * Created by transapps on 7/7/14.
 */
public class Stupa {

	private String name;

	private String lat;
	private String lon;
	private String type;
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
