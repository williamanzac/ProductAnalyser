package nz.co.fitnet.core;

import nz.co.fitnet.api.Category;
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
}
