package nz.co.fitnet.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
	private String name;// "Name": "ABC",
	private String number;// "Number": "ABC",
	private String path;// "Path": "ABC",
	private List<Category> subcategories;// "Subcategories": []
	private int count;// "Count": 0,
	private boolean restricted;// "IsRestricted": false,
	private boolean legalNotices;// "HasLegalNotice": false,
	private boolean classifieds;// "HasClassifieds": false

	@JsonProperty("Name")
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@JsonProperty("Number")
	public String getNumber() {
		return number;
	}

	public void setNumber(final String number) {
		this.number = number;
	}

	@JsonProperty("Path")
	public String getPath() {
		return path;
	}

	public void setPath(final String path) {
		this.path = path;
	}

	@JsonProperty("Subcategories")
	public List<Category> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(final List<Category> subcategories) {
		this.subcategories = subcategories;
	}

	@JsonProperty("Count")
	public int getCount() {
		return count;
	}

	public void setCount(final int count) {
		this.count = count;
	}

	@JsonProperty("IsRestricted")
	public boolean isRestricted() {
		return restricted;
	}

	public void setRestricted(final boolean restricted) {
		this.restricted = restricted;
	}

	@JsonProperty("HasLegalNotice")
	public boolean isLegalNotices() {
		return legalNotices;
	}

	public void setLegalNotices(final boolean legalNotices) {
		this.legalNotices = legalNotices;
	}

	@JsonProperty("HasClassifieds")
	public boolean isClassifieds() {
		return classifieds;
	}

	public void setClassifieds(final boolean classifieds) {
		this.classifieds = classifieds;
	}
}
