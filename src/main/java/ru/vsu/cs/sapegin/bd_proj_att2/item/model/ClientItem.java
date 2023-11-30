package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "client")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY - БД отвечает за генерацию ID
    private int client_id;

    //Не используем @Column, так как названия совпадают с названиями в таблице
    private String passport_ser;
    private String passport_num;
    private String surname;

    private String name;

    private String phone;

    @OneToMany(mappedBy = "client") //название поля, которое сюда ссылается
    private List<ServiceItem> services;
}
