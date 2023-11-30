package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "car")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "car_id")
public class CarItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int car_id;

    private String reg_number;
    private String brand;
    private int year;
    private int cost;
    @JsonIgnore
    @OneToMany(mappedBy = "car")
    private List<ServiceItem> services;
}
