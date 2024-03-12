package security.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id

    private int user_id;
    private String username;
    private String password;
    private String email;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_role",joinColumns=@JoinColumn(name = "user_id"),inverseJoinColumns=@JoinColumn(referencedColumnName = "role_id"))
    private Set<Role>roles;
}
