package ru.vsu.cs.sapegin.bd_proj_att2.api.model;

import com.fasterxml.jackson.annotation.JsonView;
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
public class CarDto {
//    @JsonView(Views.ForClient.class)
    private int car_id;
//    @JsonView(Views.Other.class)
    private String reg_number;
//    @JsonView(Views.Other.class)
    private String brand;
//    @JsonView(Views.Other.class)
    private int year;
//    @JsonView(Views.Other.class)
    private int cost;

    private List<ServiceDto> services;
}
