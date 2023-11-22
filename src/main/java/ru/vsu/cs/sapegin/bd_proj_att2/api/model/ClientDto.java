package ru.vsu.cs.sapegin.bd_proj_att2.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientDto {
    private int id;
    private String reg_number;
    private String brand;
    private int year;
    private int cost;
}
