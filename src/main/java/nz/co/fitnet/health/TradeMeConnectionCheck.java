package nz.co.fitnet.health;

import nz.co.fitnet.client.TradeMeClient;

import com.codahale.metrics.health.HealthCheck;

public class TradeMeConnectionCheck extends HealthCheck {

	private final TradeMeClient client;

	public TradeMeConnectionCheck(TradeMeClient client) {
		super();
		this.client = client;
	}

	@Override
	protected Result check() throws Exception {
		return client.checkConnection() ? Result.healthy() : Result.unhealthy("not connected");
	}
}
