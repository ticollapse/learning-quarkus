package teste.vitor.resource;

import teste.vitor.model.Order;
import teste.vitor.repository.OrderRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;

@Path("/ordens")
public class OrderResource {

    @Inject
    OrderRepository orderRepository;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Order order){
        order.setDate(LocalDate.now());
        order.setStatus("ENVIADA");
        orderRepository.persist(order);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> list(){
        return orderRepository.findAll().list();
    }

}