package com.ettakip.EtTakip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessDto {
    private Long id;
    @NotNull
    private String name;
    private Date datetime;
}
