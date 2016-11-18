package nz.co.fitnet.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeeTier {
	private float minimumTierPrice; // MinimumTierPrice
	private float fixedFee; // FixedFee
	private float percentageFee; // PercentageFee

	@JsonProperty("MinimumTierPrice")
	public float getMinimumTierPrice() {
		return minimumTierPrice;
	}

	public void setMinimumTierPrice(float minimumTierPrice) {
		this.minimumTierPrice = minimumTierPrice;
	}

	@JsonProperty("FixedFee")
	public float getFixedFee() {
		return fixedFee;
	}

	public void setFixedFee(float fixedFee) {
		this.fixedFee = fixedFee;
	}

	@JsonProperty("PercentageFee")
	public float getPercentageFee() {
		return percentageFee;
	}

	public void setPercentageFee(float percentageFee) {
		this.percentageFee = percentageFee;
	}
}
