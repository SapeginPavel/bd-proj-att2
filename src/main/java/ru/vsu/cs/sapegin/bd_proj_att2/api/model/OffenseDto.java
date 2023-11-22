package ru.vsu.cs.sapegin.bd_proj_att2.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OffenseDto {
    private int id;
    private String problem;
    private int fine;
}
