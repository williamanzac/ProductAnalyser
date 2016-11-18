package nz.co.fitnet.client;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import nz.co.fitnet.TradeMeConfig;
import nz.co.fitnet.api.Category;
import nz.co.fitnet.api.CategoryDetails;
import nz.co.fitnet.api.Duration;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.Before;
import org.junit.Test;

public class TradeMeClientTest {
	private TradeMeClient cut;
	private HttpClient httpClient;
	private TradeMeConfig tradeMeConfig;
	private HttpResponse httpResponse;
	private HttpEntity httpEntity;

	@Before
	public void setup() throws Exception {
		httpClient = mock(HttpClient.class);
		tradeMeConfig = mock(TradeMeConfig.class);
		cut = spy(new TradeMeClient(httpClient, tradeMeConfig));
		httpResponse = mock(HttpResponse.class);
		httpEntity = mock(HttpEntity.class);
		when(httpResponse.getEntity()).thenReturn(httpEntity);
		when(httpClient.execute(any(HttpGet.class))).thenReturn(httpResponse);
		when(tradeMeConfig.getBaseUrl()).thenReturn("http://localhost");
	}

	@Test
	public void verifyRootCategory() throws Exception {
		when(httpEntity.getContent()).thenReturn(getClass().getResourceAsStream("RootCategory.json"));
		final Category actual = cut.getCategories(null, 1, null);

		// verify(cut.get(eq("Categories/1443/Details"), anyMap(), eq(CategoryDetails.class)));
		assertThat(actual, is(notNullValue()));
		assertThat(actual.getName(), equalTo("Root"));
	}

	@Test
	public void verifyCategoryDetails() throws Exception {
		when(httpEntity.getContent()).thenReturn(getClass().getResourceAsStream("CategoryDetails.json"));
		final CategoryDetails actual = cut.getCategoryDetails("1443", null, null);

		// verify(cut.get(eq("Categories/1443/Details"), anyMap(), eq(CategoryDetails.class)));
		assertThat(actual, is(notNullValue()));
		assertThat(actual.getName(), equalTo("Advertising"));
		assertThat(actual.getDefaultDuration(), equalTo(Duration.Seven));
		assertThat(actual.getAllowedDurations(), hasItem(Duration.Two));
		assertThat(actual.getFees(), notNullValue());
		assertThat(actual.getFees().getMaximumSuccessFee(), equalTo(149.0f));
	}
}
