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
    private String passport_ser;
    private String passport_num;
    private String surname;
    private String name;
    private String phone;
}
