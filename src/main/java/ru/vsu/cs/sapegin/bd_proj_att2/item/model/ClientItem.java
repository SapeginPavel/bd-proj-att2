package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;
import ru.vsu.cs.sapegin.bd_proj_att2.app.serializers.ServicesSerializer;

import java.util.List;

@Entity
@Table(name = "client")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "client_id")
public class ClientItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY - БД отвечает за генерацию ID
    @Column(name = "client_id")
    private int clientId;

    //Не используем @Column, так как названия совпадают с названиями в таблице
    private String passport_ser;
    private String passport_num;
    private String surname;

    private String name;

    private String phone;

    @JsonSerialize(using = ServicesSerializer.class)
    @OneToMany(mappedBy = "client") //название поля, которое сюда ссылается
    private List<ServiceItem> services;
}
