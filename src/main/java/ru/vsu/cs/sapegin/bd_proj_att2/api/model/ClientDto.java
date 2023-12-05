package ru.vsu.cs.sapegin.bd_proj_att2.api.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientDto {

//    @JsonView(Views.ForClient.class)
    private int client_id;

    @Size(min = 4, max = 4)
    private String passport_ser;

    @Size(min = 6, max = 6)
    private String passport_num;

    @NotEmpty(message = "Name must not me empty")
    @Size(min = 2, max = 30, message = "Incorrect length of the name") //сделать валидацию на уровне front (главное) - регулярка на формочке
    private String surname;

    @NotEmpty(message = "Name must not me empty")
    @Size(min = 2, max = 30, message = "Incorrect length of the name")
//    @JsonView(Views.ForClient.class)
    private String name;

    @Size(min = 11, max = 11)
    private String phone;

//    private List<ServiceItem> services;
}
