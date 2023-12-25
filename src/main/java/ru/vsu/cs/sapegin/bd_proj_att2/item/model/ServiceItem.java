package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "service")
//@Data
@Setter
@Getter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "service_id")
public class ServiceItem {
//    @JsonView(Views.ForClient.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_id;

//    @JsonView(Views.ForClient.class)
    private Date startDate;
//    @JsonView(Views.ForClient.class)
    private Date endDate;

//      service по отношению к ...
//    @JsonIgnore
//    @JsonView(Views.ForClient.class)
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id") //сначала - внешний ключ, потом - куда он ссылается
    private CarItem car;

//    @JsonIgnore
//    @JsonView(Views.Other.class)
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id") //где JoinColumn - Это owning side (владеющая сторона) (владеет внешним ключом)
    private ClientItem client;

//    @JsonManagedReference
//    @JsonBackReference
//    @JsonView(Views.Other.class)
//    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "offense_service",
        joinColumns = { @JoinColumn(name = "service_id") },
        inverseJoinColumns = { @JoinColumn(name = "offense_id") })
    private List<OffenseItem> offenses;

    @Override
    public String toString() {
        return "ServiceItem{" +
                "service_id=" + service_id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", car_id=" + car.getCar_id() +
                ", client_id=" + client.getClientId() +
                ", offenses=" + offenses +
                '}';
    }
}
