package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import com.fasterxml.jackson.annotation.*;
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
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "offense_id")
public class OffenseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int offense_id;

    private String problem;
    private int fine;

//    @JsonIgnore
    @ManyToMany(mappedBy = "offenses")
    private List<ServiceItem> services;
}
