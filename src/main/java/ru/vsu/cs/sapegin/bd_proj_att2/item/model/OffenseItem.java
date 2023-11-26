package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "offense")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OffenseItem {
    @Id
    @GeneratedValue
    private int offense_id;
    private String problem;
    private int fine;

    @ManyToMany(mappedBy = "offenses")
    private List<ServiceItem> services;
}
