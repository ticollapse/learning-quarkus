package teste.vitor.resource;

import teste.vitor.model.Order;
import teste.vitor.repository.OrderRepository;
import teste.vitor.service.OrderService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;

@Path("/ordens")
public class OrderResource {

    @Inject
    OrderService orderService;

    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(@Context SecurityContext securityContext, Order order){
        orderService.inserir(securityContext, order);
    }


}