package com.furkancebeci.interprobefirsthomework.entity;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Getter @Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","productComments"})
public class Users {

    @Id
    @GeneratedValue(generator = "Users")
    @SequenceGenerator(name = "Users", sequenceName = "USERS_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 50, nullable = false)
    private String surname;

    @Email
    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 15, nullable = false)
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "users")
    private Set<ProductComment> productComments = new HashSet<>();
}
