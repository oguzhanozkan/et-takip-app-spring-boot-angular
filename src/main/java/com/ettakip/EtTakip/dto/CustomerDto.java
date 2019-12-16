package com.ettakip.EtTakip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String mail;
    @NotNull
    private String phone;

    private List<UserDto> users;
    private List<ProcessDto> processes;

}
