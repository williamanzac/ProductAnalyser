package nz.co.fitnet.core;

import java.util.Date;

import nz.co.fitnet.api.Category;
import nz.co.fitnet.api.CategoryDetails;
import nz.co.fitnet.client.ClientException;
import nz.co.fitnet.client.TradeMeClient;

public class TradeMeService {
	private final TradeMeClient client;

	public TradeMeService(final TradeMeClient client) {
		super();
		this.client = client;
	}

	public Category getCategories(final Integer depth, final Integer region) throws ClientException {
		return client.getCategories(true, depth, region);
	}

	public Category getCategories(final String number, final Integer depth, final Integer region)
			throws ClientException {
		return client.getCategories(number, true, depth, region);
	}

	public CategoryDetails getCategoryDetails(final String category, final Date asAt, final Boolean catalogue)
			throws ClientException {
		return client.getCategoryDetails(category, asAt, catalogue);
	}
}
