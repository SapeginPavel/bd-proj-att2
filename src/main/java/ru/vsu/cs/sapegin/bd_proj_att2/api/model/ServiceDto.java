package ru.vsu.cs.sapegin.bd_proj_att2.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ServiceDto {
    private int id;
    private Date startDate;
    private Date endDate;

    private CarDto car;
    private ClientDto client;

    private List<OffenseDto> offenses;
}
