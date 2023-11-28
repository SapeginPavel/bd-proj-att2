package ru.vsu.cs.sapegin.bd_proj_att2.api.model;

import jakarta.persistence.MapKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientDto {
    private int client_id;
    private String passport_ser;
    private String passport_num;
    private String surname;
    private String name;
    private String phone;

    private List<ServiceItem> services;
}
