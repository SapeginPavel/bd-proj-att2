package ru.vsu.cs.sapegin.bd_proj_att2.api.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Data
@Setter
@Getter
@EqualsAndHashCode
public class ServiceDto {

    private int service_id;

    private Date startDate;

    private Date endDate;

    private CarDto car;

    private ClientDto client;

    private List<OffenseDto> offenses;

    @Override
    public String toString() {
        return "ServiceDto{" +
                "service_id=" + service_id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", car_id=" + car.getCar_id() +
                ", client_id=" + client.getClient_id() +
                ", offenses=" + offenses +
                '}';
    }
}
