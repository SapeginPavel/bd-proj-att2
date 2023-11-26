package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

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
public class CarItem {
    @Id
    @GeneratedValue
    private int car_id;
    private String reg_number;
    private String brand;
    private int year;
    private int cost;

    @OneToMany(mappedBy = "car")
    private List<ServiceItem> services;
}
