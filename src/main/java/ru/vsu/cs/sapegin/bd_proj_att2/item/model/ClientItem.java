package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "public.client")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientItem {
    @Id
    @GeneratedValue
    private int id;

    //Не используем @Column, так как названия совпадают с названиями в таблице
    private String passport_ser;
    private String passport_num;
    private String surname;

    @NotEmpty(message = "Name must not me empty")
    @Size(min = 2, max = 30, message = "Incorrect length of the name")
    private String name;

    @Size(min = 11, max = 11)
    private String phone;
}
