package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
