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
    private int car_id;
    private String reg_number;
    private String brand;
    private int year;
    private int cost;

    private List<ServiceDto> services;
}
