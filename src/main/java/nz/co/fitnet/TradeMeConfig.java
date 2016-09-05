package nz.co.fitnet;

import io.dropwizard.client.HttpClientConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TradeMeConfig {
	@Valid
	@NotNull
	@JsonProperty
	private final HttpClientConfiguration httpClient = new HttpClientConfiguration();
	@Valid
	@NotNull
	@JsonProperty
	private String baseUrl;

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public HttpClientConfiguration getHttpClient() {
		return httpClient;
	}
}
