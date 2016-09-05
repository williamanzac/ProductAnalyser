package nz.co.fitnet.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import nz.co.fitnet.TradeMeConfig;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

public class TradeMeClient {
	private static final String urlBase = "https://api.trademe.co.nz/";
	private static final String sandboxUrlBase = "https://api.tmsandbox.co.nz/";

	private final HttpClient tradeMeClient;
	private final TradeMeConfig tradeMeConfig;

	public TradeMeClient(final HttpClient tradeMeClient, TradeMeConfig tradeMeConfig) {
		super();
		this.tradeMeClient = tradeMeClient;
		this.tradeMeConfig = tradeMeConfig;
	}

	public InputStream get(final String subUrl) throws ClientException {
		try {
			final URIBuilder builder = new URIBuilder(tradeMeConfig.getBaseUrl());
			builder.setPath("v1/" + subUrl);
			final URI uri = builder.build();
			final HttpGet get = new HttpGet(uri);

			final HttpResponse response = tradeMeClient.execute(get);

			return response.getEntity().getContent();
		} catch (URISyntaxException | IOException e) {
			throw new ClientException(e);
		}
	}
}
