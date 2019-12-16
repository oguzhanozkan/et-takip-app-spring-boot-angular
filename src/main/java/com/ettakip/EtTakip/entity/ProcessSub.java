package com.ettakip.EtTakip.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "processSub")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class ProcessSub implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private SubProcessType Type;

    @Column(name = "description", length = 300)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "proc_start")
    private Date proc_start;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "proc_end")
    private Date proc_end;

    @JsonBackReference
    @JoinColumn(name = "process_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Process process;
}
