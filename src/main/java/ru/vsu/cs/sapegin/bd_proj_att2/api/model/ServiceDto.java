package ru.vsu.cs.sapegin.bd_proj_att2.api.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import ru.vsu.cs.sapegin.bd_proj_att2.app.Views;

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

//    @JsonView(Views.ForClient.class)
    private int service_id;

//    @JsonView(Views.ForClient.class)
    private Date startDate;

//    @JsonView(Views.ForClient.class)
    private Date endDate;

//    @JsonView(Views.ForClient.class)
    private CarDto car;

//    @JsonView(Views.Other.class)
    private ClientDto client;

//    @JsonView(Views.Other.class)
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
