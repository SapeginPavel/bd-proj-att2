package ru.vsu.cs.sapegin.bd_proj_att2.api.model.special;

import lombok.*;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.CarDto;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.OffenseDto;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Data
@Setter
@Getter
@EqualsAndHashCode
public class ServiceDtoForSingleClient {
    private int service_id;

    private Date startDate;

    private Date endDate;

    private int car_id;

    @Override
    public String toString() {
        return "ServiceDto{" +
                "service_id=" + service_id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", car_id=" + car_id +
                '}';
    }
}
