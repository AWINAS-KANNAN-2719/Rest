package com.tutorialpoint.rest.Controller;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("Download")
public class DownloadController {

	@Path("pdf")
	@Produces("application/pdf")
	@GET
	public Response getPdf() {

		File file = new File("D:\\STS workspace\\Rest\\BNEPA4260N_2019-20.pdf");

		ResponseBuilder rb = Response.ok((Object) file);
		rb.header("Content-Disposition", "attachment; filename=Form.pdf");
		return rb.build();
	}

}
