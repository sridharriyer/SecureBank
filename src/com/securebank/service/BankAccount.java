package com.securebank.cxfrestservice;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.securebank.cxfrestservice.exception.InvalidIDException;


@Path("/")
@WebService(name="accountService", targetNamespace="http://www.securebank.com/account")
public interface BankAccount {

	@POST
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/createAccount")
	public Response createAccount
		(@QueryParam("firstname") String firstName,
		 @QueryParam("lastname") String lastName,
		 @QueryParam("email") String email,
		 @QueryParam("phone") String phone,
		 @QueryParam("onlineid") String onlineId);
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	@Path("/getAccount")
	public Response getAccount(@QueryParam("onllineid") String onlineId) throws InvalidIDException;
							
}
