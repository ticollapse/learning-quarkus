package org.acme.opentracing;

import org.jboss.logging.Logger;

import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/traced")
public class TracedResource {
    private static final Logger LOG = Logger.getLogger(TracedResource.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello(){
        LOG.info("Traced Hello");
        return "hello";
    }
}
