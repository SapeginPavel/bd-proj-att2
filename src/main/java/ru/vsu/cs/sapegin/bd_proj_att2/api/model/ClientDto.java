package ru.vsu.cs.sapegin.bd_proj_att2.api.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.special.ServiceDtoForSingleClient;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientDto {

    private int client_id;

    @Size(min = 4, max = 4)
    private String passport_ser;

    @Size(min = 6, max = 6)
    private String passport_num;

//    @NotEmpty(message = "Name must not me empty")
    @Size(min = 2, max = 30, message = "Incorrect length of the name")
    private String surname;

//    @NotEmpty(message = "Name must not me empty")
    @Size(min = 2, max = 30, message = "Incorrect length of the name")
    private String name;

    @Size(min = 11, max = 11)
    private String phone;

    //Пока в этом поле смысла нет (в основном, так как зацикливает и содержит объективно лишнюю инфу)
    private List<ServiceDto> services;

//    private List<Integer> services_id;

    private List<ServiceDtoForSingleClient> serviceDtoForSingleClients;

}
