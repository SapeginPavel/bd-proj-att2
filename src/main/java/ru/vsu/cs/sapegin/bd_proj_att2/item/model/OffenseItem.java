package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "public.offense")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OffenseItem {
    @Id
    @GeneratedValue
    private int id;
    private String problem;
    private int fine;

    @ManyToMany(mappedBy = "offenses")
    private List<ServiceItem> services;
}
