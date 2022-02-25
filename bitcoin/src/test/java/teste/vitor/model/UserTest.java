package teste.vitor.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

@QuarkusTest
public class UserTest {

    @Test
    public void FindByIdOptionalIsReturningCorrectUserTest(){
        PanacheMock.mock(User.class);

        User u = new User();
        Optional<PanacheEntityBase> user = Optional.of(u);

        Mockito.when(User.findByIdOptional(40)).thenReturn(user);

        Assertions.assertSame(u,User.findByIdOptional(40).get());

    }

}
