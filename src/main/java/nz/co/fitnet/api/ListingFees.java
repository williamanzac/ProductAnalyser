package nz.co.fitnet.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListingFees {
	private float bold;// Bold
	private float bundle; // Bundle
	private float endDate; // EndDate
	private float feature; // Feature
	private float gallery; // Gallery
	private float galleryPlus; // GalleryPlus
	private float highlight; // Highlight
	private float homepage; // Homepage
	private float listing; // Listing
	private float multiPhoto; // MultiPhoto
	private float reserve; // Reserve
	private float subtitle; // Subtitle
	private float tenDays; // TenDays
	private float withdrawal; // Withdrawal
	private float superFeature; // SuperFeature
	private float superFeatureBundle; // SuperFeatureBundle
	private float highVolume; // HighVolume
	private List<FeeTier> feeTiers; // ListingFeeTiers
	private float minimumSuccessFee; // MinimumSuccessFee
	private float maximumSuccessFee; // MaximumSuccessFee
	private List<FeeTier> successFeeTiers; // SuccessFeeTiers
	private float branding; // Branding

	@JsonProperty("Bold")
	public float getBold() {
		return bold;
	}

	public void setBold(float bold) {
		this.bold = bold;
	}

	@JsonProperty("Bundle")
	public float getBundle() {
		return bundle;
	}

	public void setBundle(float bundle) {
		this.bundle = bundle;
	}

	@JsonProperty("EndDate")
	public float getEndDate() {
		return endDate;
	}

	public void setEndDate(float endDate) {
		this.endDate = endDate;
	}

	@JsonProperty("Feature")
	public float getFeature() {
		return feature;
	}

	public void setFeature(float feature) {
		this.feature = feature;
	}

	@JsonProperty("Gallery")
	public float getGallery() {
		return gallery;
	}

	public void setGallery(float gallery) {
		this.gallery = gallery;
	}

	@JsonProperty("GalleryPlus")
	public float getGalleryPlus() {
		return galleryPlus;
	}

	public void setGalleryPlus(float galleryPlus) {
		this.galleryPlus = galleryPlus;
	}

	@JsonProperty("Highlight")
	public float getHighlight() {
		return highlight;
	}

	public void setHighlight(float highlight) {
		this.highlight = highlight;
	}

	@JsonProperty("Homepage")
	public float getHomepage() {
		return homepage;
	}

	public void setHomepage(float homepage) {
		this.homepage = homepage;
	}

	@JsonProperty("Listing")
	public float getListing() {
		return listing;
	}

	public void setListing(float listing) {
		this.listing = listing;
	}

	@JsonProperty("MultiPhoto")
	public float getMultiPhoto() {
		return multiPhoto;
	}

	public void setMultiPhoto(float multiPhoto) {
		this.multiPhoto = multiPhoto;
	}

	@JsonProperty("Reserve")
	public float getReserve() {
		return reserve;
	}

	public void setReserve(float reserve) {
		this.reserve = reserve;
	}

	@JsonProperty("Subtitle")
	public float getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(float subtitle) {
		this.subtitle = subtitle;
	}

	@JsonProperty("TenDays")
	public float getTenDays() {
		return tenDays;
	}

	public void setTenDays(float tenDays) {
		this.tenDays = tenDays;
	}

	@JsonProperty("Withdrawal")
	public float getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(float withdrawal) {
		this.withdrawal = withdrawal;
	}

	@JsonProperty("SuperFeature")
	public float getSuperFeature() {
		return superFeature;
	}

	public void setSuperFeature(float superFeature) {
		this.superFeature = superFeature;
	}

	@JsonProperty("SuperFeatureBundle")
	public float getSuperFeatureBundle() {
		return superFeatureBundle;
	}

	public void setSuperFeatureBundle(float superFeatureBundle) {
		this.superFeatureBundle = superFeatureBundle;
	}

	@JsonProperty("HighVolume")
	public float getHighVolume() {
		return highVolume;
	}

	public void setHighVolume(float highVolume) {
		this.highVolume = highVolume;
	}

	@JsonProperty("FeeTiers")
	public List<FeeTier> getFeeTiers() {
		return feeTiers;
	}

	public void setFeeTiers(List<FeeTier> feeTiers) {
		this.feeTiers = feeTiers;
	}

	@JsonProperty("MinimumSuccessFee")
	public float getMinimumSuccessFee() {
		return minimumSuccessFee;
	}

	public void setMinimumSuccessFee(float minimumSuccessFee) {
		this.minimumSuccessFee = minimumSuccessFee;
	}

	@JsonProperty("MaximumSuccessFee")
	public float getMaximumSuccessFee() {
		return maximumSuccessFee;
	}

	public void setMaximumSuccessFee(float maximumSuccessFee) {
		this.maximumSuccessFee = maximumSuccessFee;
	}

	@JsonProperty("SuccessFeeTiers")
	public List<FeeTier> getSuccessFeeTiers() {
		return successFeeTiers;
	}

	public void setSuccessFeeTiers(List<FeeTier> successFeeTiers) {
		this.successFeeTiers = successFeeTiers;
	}

	@JsonProperty("Branding")
	public float getBranding() {
		return branding;
	}

	public void setBranding(float branding) {
		this.branding = branding;
	}
}