package nz.co.fitnet;

import io.dropwizard.Application;
import io.dropwizard.client.HttpClientBuilder;
import io.dropwizard.setup.Environment;
import nz.co.fitnet.client.TradeMeClient;
import nz.co.fitnet.core.TradeMeService;
import nz.co.fitnet.health.TradeMeConnectionCheck;
import nz.co.fitnet.resources.TradeMeResource;

import org.apache.http.client.HttpClient;

public class App extends Application<AppConfig> {

	public static void main(final String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public void run(final AppConfig configuration, final Environment environment) throws Exception {
		final TradeMeConfig tradeMeConfig = configuration.getTradeMe();

		final HttpClient tradeMeClient = new HttpClientBuilder(environment).using(tradeMeConfig.getHttpClient()).build(
				"TradeMe");

		final TradeMeClient client = new TradeMeClient(tradeMeClient, tradeMeConfig);

		final TradeMeService tradeMeService = new TradeMeService(client);

		final TradeMeResource tradeMeResource = new TradeMeResource(tradeMeService);

		environment.jersey().register(tradeMeResource);

		final TradeMeConnectionCheck tradeMeConnectionCheck = new TradeMeConnectionCheck(client);
		environment.healthChecks().register("trademe", tradeMeConnectionCheck);
	}
}
