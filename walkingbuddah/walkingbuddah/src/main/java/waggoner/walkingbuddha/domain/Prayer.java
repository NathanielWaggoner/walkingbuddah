package waggoner.walkingbuddha.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by transapps on 7/7/14.
 */
public class Prayer {

	@SerializedName("name")
	private String name;
	@SerializedName("text_eng")
	private String text_eng;
	@SerializedName("text_phon")
	private String text_phon;
	@SerializedName("text_phon_font")
	private String text_phon_font;
	@SerializedName("text_non_eng")
	private String text_non_eng;
	@SerializedName("text_non_eng_font")
	private String text_non_eng_font;

	public Prayer() {

	}
	public String getText_non_eng_font() {
		return text_non_eng_font;
	}

	public void setText_non_eng_font(String text_non_eng_font) {
		this.text_non_eng_font = text_non_eng_font;
	}

	public String getText_non_eng() {
		return text_non_eng;
	}

	public void setText_non_eng(String text_non_eng) {
		this.text_non_eng = text_non_eng;
	}

	public String getText_phon_font() {
		return text_phon_font;
	}

	public void setText_phon_font(String text_phon_font) {
		this.text_phon_font = text_phon_font;
	}

	public String getText_phon() {
		return text_phon;
	}

	public void setText_phon(String text_phon) {
		this.text_phon = text_phon;
	}

	public String getText_eng() {
		return text_eng;
	}

	public void setText_eng(String text_eng) {
		this.text_eng = text_eng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
