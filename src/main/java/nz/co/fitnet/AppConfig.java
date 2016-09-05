package nz.co.fitnet;

import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppConfig extends Configuration {
	@Valid
	@NotNull
	@JsonProperty
	private final TradeMeConfig tradeMe = new TradeMeConfig();

	public TradeMeConfig getTradeMe() {
		return tradeMe;
	}
}
