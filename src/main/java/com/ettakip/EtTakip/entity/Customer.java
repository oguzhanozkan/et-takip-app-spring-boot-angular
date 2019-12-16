package com.ettakip.EtTakip.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@ApiModel(value = "Customer Data")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "id")
    private Long id;

    @Column(name = "customer_name", length = 150, unique = true)
    @NonNull
    @ApiModelProperty(value = "name", required = true)
    private String name;

    @Column(name = "customer_mail", length = 150)
    @NonNull
    @ApiModelProperty(value = "mail", required = true)
    private String mail;

    @Column(name = "customer_phone", length = 150)
    @NonNull
    @ApiModelProperty(value = "phone", required = true)
    private String phone;

     @ApiModelProperty(value = "users")
     @JoinColumn(name = "customer_user")
     @OneToMany(fetch = FetchType.LAZY)
     private List<User> users;

     @ApiModelProperty(value = "process")
     @JoinColumn(name = "customer_process_id")
     @OneToMany(fetch = FetchType.LAZY)
     private List<Process> processes;

}
