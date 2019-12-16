package com.ettakip.EtTakip.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "u_name", length = 50, nullable = false)
    private String name;

    @Column(name = "u_mail", length = 150, nullable = false, unique = true)
    private String mail;

    @Column(name = "u_pwd", length = 200, nullable = false)
    private String pwd;

    @Column(name = "u_phone", length = 20, nullable = false, unique = true)
    private String phone;

    @Column(name = "u_is_admin", nullable = false)
    private Boolean isAdmin;

    //@JsonIgnore
    @JsonBackReference
    @JoinColumn(name = "customer_user")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customers;

}

