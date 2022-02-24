package teste.vitor.resource;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import teste.vitor.model.Bitcoin;
import teste.vitor.service.BitcoinService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/bitcoins")
public class BitcoinResource{

    @Inject
    @RestClient
    BitcoinService bitcoinService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitcoin> getBitcoins(){
        return bitcoinService.getBitcoins();
    }

}
