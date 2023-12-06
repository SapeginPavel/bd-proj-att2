package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import ru.vsu.cs.sapegin.bd_proj_att2.app.Views;

import java.util.List;

@Entity
@Table(name = "car")
//@Data
@Setter
@Getter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "car_id")
public class CarItem {

//    @JsonView(Views.ForClient.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int car_id;

//    @JsonView(Views.Other.class)
    private String reg_number;
//    @JsonView(Views.Other.class)
    private String brand;
//    @JsonView(Views.Other.class)
    private int year;
//    @JsonView(Views.Other.class)
    private int cost;

//    @JsonIgnore
//    @JsonView(Views.Other.class)
    @OneToMany(mappedBy = "car")
    private List<ServiceItem> services;
}
