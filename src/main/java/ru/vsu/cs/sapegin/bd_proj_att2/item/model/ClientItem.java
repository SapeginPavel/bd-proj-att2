package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;
import ru.vsu.cs.sapegin.bd_proj_att2.app.Views;
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

    @JsonView(Views.ForClient.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //IDENTITY - БД отвечает за генерацию ID
    private int client_id;

    //Не используем @Column, так как названия совпадают с названиями в таблице
    private String passport_ser;
    private String passport_num;
    private String surname;

    private String name;

    private String phone;

//    @JsonIgnore
//    @JsonView(Views.ForClient.class)
    @JsonSerialize(using = ServicesSerializer.class)
    @OneToMany(mappedBy = "client") //название поля, которое сюда ссылается
    private List<ServiceItem> services;
}
