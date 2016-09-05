package nz.co.fitnet;

import io.dropwizard.Application;
import io.dropwizard.client.HttpClientBuilder;
import io.dropwizard.setup.Environment;
import nz.co.fitnet.client.TradeMeClient;

import org.apache.http.client.HttpClient;

public class App extends Application<AppConfig> {

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public void run(AppConfig configuration, Environment environment) throws Exception {
		final TradeMeConfig tradeMeConfig = configuration.getTradeMe();

		final HttpClient tradeMeClient = new HttpClientBuilder(environment).using(tradeMeConfig.getHttpClient()).build(
				"TradeMe");

		final TradeMeClient client = new TradeMeClient(tradeMeClient, tradeMeConfig);
	}
}
