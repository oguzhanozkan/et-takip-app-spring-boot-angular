package com.ettakip.EtTakip.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "process")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Process implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "process_name", length = 100)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date datetime;

    @JoinColumn(name = "process_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<ProcessSub> subProcess;

    @JsonBackReference
    @JoinColumn(name = "customer_process_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customer;

}
