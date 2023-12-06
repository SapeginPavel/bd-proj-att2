package ru.vsu.cs.sapegin.bd_proj_att2.api.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vsu.cs.sapegin.bd_proj_att2.app.Views;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientDto {

//    @JsonView(Views.ForClient.class)
    private int client_id;

//    @JsonView(Views.ForClient.class)
    @Size(min = 4, max = 4)
    private String passport_ser;

//    @JsonView(Views.ForClient.class)
    @Size(min = 6, max = 6)
    private String passport_num;

//    @JsonView(Views.ForClient.class)
    @NotEmpty(message = "Name must not me empty")
    @Size(min = 2, max = 30, message = "Incorrect length of the name") //сделать валидацию на уровне front (главное) - регулярка на формочке
    private String surname;

//    @JsonView(Views.ForClient.class)
    @NotEmpty(message = "Name must not me empty")
    @Size(min = 2, max = 30, message = "Incorrect length of the name")
//    @JsonView(Views.ForClient.class)
    private String name;

//    @JsonView(Views.ForClient.class)
    @Size(min = 11, max = 11)
    private String phone;

//    @JsonView(Views.ForClient.class)
    private List<ServiceDto> services;

    private List<Integer> services_id;

}
