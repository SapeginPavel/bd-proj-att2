package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "service")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

//todo: что делать с тем, что нам не нужен конструктор со всеми полями (id не надо передавать)

public class ServiceItem {

    @Id
    @GeneratedValue
    private int service_id;

    private Date startDate;
    private Date endDate;

    //service по отношению к ...

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "car_id") //сначала - внешний ключ, потом - куда он ссылается
    private CarItem car;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id") //где JoinColumn - Это owning side (владеющая сторона) (владеет внешним ключом)
    private ClientItem client;

    @ManyToMany
    @JoinTable(name = "public.offense_service",
        joinColumns = { @JoinColumn(name = "service_id") },
        inverseJoinColumns = { @JoinColumn(name = "offense_id") })
    private List<OffenseItem> offenses;
}
