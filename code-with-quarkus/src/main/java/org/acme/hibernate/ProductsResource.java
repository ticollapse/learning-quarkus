package org.acme.hibernate;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
@Transactional
public class ProductsResource {

    @Inject EntityManager entityManager;

    @GET
    @Produces (value = MediaType.APPLICATION_JSON)
    public List<Product> getProducts(){
        return entityManager.createQuery("select p from Product p",Product.class).getResultList();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    public void insertProduct(Product product){
        entityManager.persist(product);
    }
}
