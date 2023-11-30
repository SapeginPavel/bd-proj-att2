package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "service")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "service_id")
public class ServiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int service_id;

    private Date startDate;
    private Date endDate;

//      service по отношению к ...
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id") //сначала - внешний ключ, потом - куда он ссылается
    private CarItem car;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id") //где JoinColumn - Это owning side (владеющая сторона) (владеет внешним ключом)
    private ClientItem client;

//    @JsonManagedReference
//    @JsonBackReference
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "offense_service",
        joinColumns = { @JoinColumn(name = "service_id") },
        inverseJoinColumns = { @JoinColumn(name = "offense_id") })
    private List<OffenseItem> offenses;
}
