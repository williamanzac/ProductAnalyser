package nz.co.fitnet.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDetails {
	private int categoryId; // CategoryId
	private String name; // Name
	private String path; // Path
	private boolean canListAuctions; // CanListAuctions
	private boolean canListClassifieds; // CanListClassifieds
	private boolean canRelist; // CanRelist
	private Duration defaultDuration; // DefaultDuration
	private List<Duration> allowedDurations;// AllowedDurations
	private ListingFees fees; // Fees

	@JsonProperty("CategoryId")
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@JsonProperty("Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("Path")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@JsonProperty("CanListAuctions")
	public boolean isCanListAuctions() {
		return canListAuctions;
	}

	public void setCanListAuctions(boolean canListAuctions) {
		this.canListAuctions = canListAuctions;
	}

	@JsonProperty("CanListClassifieds")
	public boolean isCanListClassifieds() {
		return canListClassifieds;
	}

	public void setCanListClassifieds(boolean canListClassifieds) {
		this.canListClassifieds = canListClassifieds;
	}

	@JsonProperty("CanRelist")
	public boolean isCanRelist() {
		return canRelist;
	}

	public void setCanRelist(boolean canRelist) {
		this.canRelist = canRelist;
	}

	@JsonProperty("DefaultDuration")
	public Duration getDefaultDuration() {
		return defaultDuration;
	}

	public void setDefaultDuration(Duration defaultDuration) {
		this.defaultDuration = defaultDuration;
	}

	@JsonProperty("AllowedDurations")
	public List<Duration> getAllowedDurations() {
		return allowedDurations;
	}

	public void setAllowedDurations(List<Duration> allowedDurations) {
		this.allowedDurations = allowedDurations;
	}

	@JsonProperty("Fees")
	public ListingFees getFees() {
		return fees;
	}

	public void setFees(ListingFees fees) {
		this.fees = fees;
	}
}
