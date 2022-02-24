package teste.vitor.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import teste.vitor.model.Order;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order> {

}
