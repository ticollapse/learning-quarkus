package teste.vitor.service;

import teste.vitor.model.Order;
import teste.vitor.model.User;
import teste.vitor.repository.OrderRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository orderRepository;

    public void inserir(SecurityContext securityContext, Order order) {
        Optional<User> userOptional =
                User.findByIdOptional(order.getUserId());
        User user = userOptional.orElseThrow();

        if(!user.getUsername().equals(securityContext.getUserPrincipal().getName())){
            throw new RuntimeException("O usuário informado na requisição é diferente do usuário logado");
        }
        order.setDate(LocalDate.now());
        order.setStatus("ENVIADA");
        orderRepository.persist(order);
    }

    public List<Order> list(){
        return orderRepository.listAll();
    }

}
