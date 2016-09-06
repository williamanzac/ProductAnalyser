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
	@Valid
	@NotNull
	@JsonProperty
	private String key;
	@Valid
	@NotNull
	@JsonProperty
	private String secret;

	public String getKey() {
		return key;
	}

	public void setKey(final String key) {
		this.key = key;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(final String secret) {
		this.secret = secret;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(final String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public HttpClientConfiguration getHttpClient() {
		return httpClient;
	}
}
