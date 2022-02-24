package teste.vitor.resource;

import teste.vitor.model.User;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/usuarios")
public class UserResource {

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(User user){
        User.persist(user);
    }

}
