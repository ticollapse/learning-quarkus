package teste.vitor.model;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@UserDefinition
@Table(name = "usuario")
public class User extends PanacheEntityBase {//Active record - controverso - classe inflada devida extensao

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    private String cpf;

    @Username
    private String username;

    @Password
    private String password;

    @Roles
    private String role;

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    @JsonbTransient
    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public static void insert(User user){
        user.password = BcryptUtil.bcryptHash(user.password);
        user.role = validateUsername(user.username);
        user.persist();
    }

    private static String validateUsername(String username){
        if(username.equals("vitor")){
            return "admin";
        }
        return "user";
    }



}
