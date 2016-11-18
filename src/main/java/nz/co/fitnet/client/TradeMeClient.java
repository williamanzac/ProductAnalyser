package nz.co.fitnet.client;

import static java.text.MessageFormat.format;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.core.MediaType;

import nz.co.fitnet.TradeMeConfig;
import nz.co.fitnet.api.Category;
import nz.co.fitnet.api.CategoryDetails;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;

public class TradeMeClient {
	private static final String urlBase = "https://api.trademe.co.nz";
	private static final String sandboxUrlBase = "https://api.tmsandbox.co.nz";
	private static final Logger LOGGER = Logger.getLogger(TradeMeClient.class);

	private final HttpClient tradeMeClient;
	private final TradeMeConfig tradeMeConfig;

	public TradeMeClient(final HttpClient tradeMeClient, final TradeMeConfig tradeMeConfig) {
		super();
		this.tradeMeClient = tradeMeClient;
		this.tradeMeConfig = tradeMeConfig;
	}

	public boolean checkConnection() {
		try {
			final URIBuilder builder = new URIBuilder(tradeMeConfig.getBaseUrl());
			builder.setPath("/v1/Categories.json");
			builder.addParameter("depth", "0");
			final URI uri = builder.build();
			LOGGER.info(uri);
			final HttpGet get = new HttpGet(uri);
			final HttpResponse response = tradeMeClient.execute(get);
			LOGGER.info(response);
			return response.getStatusLine().getStatusCode() == 200;
		} catch (URISyntaxException | IOException e) {
			LOGGER.error(e);
		}
		return false;
	}

	InputStream get(final String subUrl, final Map<String, Object> params) throws ClientException {
		try {
			final URIBuilder builder = new URIBuilder(tradeMeConfig.getBaseUrl());
			builder.setPath("/v1/" + subUrl + ".json");
			for (final Entry<String, Object> entry : params.entrySet()) {
				builder.addParameter(entry.getKey(), entry.getValue().toString());
			}
			final URI uri = builder.build();
			LOGGER.info(uri);
			final HttpGet get = new HttpGet(uri);
			get.addHeader("Accepts", MediaType.APPLICATION_JSON);
			get.addHeader("Content-Type", MediaType.APPLICATION_JSON);
			get.addHeader(
					"Authorization",
					format("OAuth oauth_consumer_key=\"{0}\", oauth_signature_method=\"PLAINTEXT\", oauth_signature=\"{1}%26\"",
							tradeMeConfig.getKey(), tradeMeConfig.getSecret()));

			final HttpResponse response = tradeMeClient.execute(get);

			return response.getEntity().getContent();
		} catch (URISyntaxException | IOException e) {
			throw new ClientException(e);
		}
	}

	<T> T get(final String subUrl, final Map<String, Object> params, final Class<T> responseClass)
			throws ClientException {
		final ObjectMapper mapper = new ObjectMapper();
		try {
			final InputStream response = get(subUrl, params);

			final T result = mapper.readValue(response, responseClass);
			return result;
		} catch (final IOException e) {
			throw new ClientException(e);
		}
	}

	public Category getCategories(final Boolean withCounts, final Integer depth, final Integer region)
			throws ClientException {
		return getCategories(null, withCounts, depth, region);
	}

	public Category getCategories(final String number, final Boolean withCounts, final Integer depth,
			final Integer region) throws ClientException {
		final Map<String, Object> params = new HashMap<>();
		if (depth != null) {
			params.put("depth", depth);
		}
		if (region != null) {
			params.put("region", region);
		}
		if (withCounts != null) {
			params.put("with_counts", withCounts);
		}
		String subUrl = "Categories";
		if (!Strings.isNullOrEmpty(number)) {
			subUrl += "/" + number;
		}
		return get(subUrl, params, Category.class);
	}

	public CategoryDetails getCategoryDetails(final String category, final Date asAt, final Boolean catalogue)
			throws ClientException {
		final Map<String, Object> params = new HashMap<>();
		if (asAt != null) {
			params.put("as_at", asAt);
		}
		if (catalogue != null) {
			params.put("catalogue", catalogue);
		}
		String subUrl = "Categories/" + category + "/Details";
		return get(subUrl, params, CategoryDetails.class);
	}
}
