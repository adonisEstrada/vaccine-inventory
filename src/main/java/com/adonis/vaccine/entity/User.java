package com.adonis.vaccine.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Entity
@NoArgsConstructor
@Table(name = "users")
@Builder
@AllArgsConstructor
public class User {

    @Id
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Employee employee;

    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    private String password;

    private String fullName;
    @NotNull
    @Column(unique = true)

    private String dni;
    @ManyToMany()
    @Builder.Default
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Roles> roles = new HashSet<>();

}
