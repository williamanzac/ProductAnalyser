package nz.co.fitnet.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nz.co.fitnet.api.Category;
import nz.co.fitnet.api.CategoryDetails;
import nz.co.fitnet.client.ClientException;
import nz.co.fitnet.core.TradeMeService;

@Path("/trademe")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TradeMeResource {
	private final TradeMeService service;

	public TradeMeResource(final TradeMeService service) {
		super();
		this.service = service;
	}

	@GET
	@Path("/category/root")
	public Response getRootCategory() throws ClientException {
		final Category categories = service.getCategories(null, null);
		return Response.ok(categories).build();
	}

	@GET
	@Path("/category/{number}")
	public Response getCategory(final @PathParam("number") String number) throws ClientException {
		final Category categories = service.getCategories(number, null, null);
		return Response.ok(categories).build();
	}

	@GET
	@Path("/category/{number}/details")
	public Response getCategoryDetails(final @PathParam("number") String number) throws ClientException {
		final CategoryDetails categories = service.getCategoryDetails(number, null, null);
		return Response.ok(categories).build();
	}
}
