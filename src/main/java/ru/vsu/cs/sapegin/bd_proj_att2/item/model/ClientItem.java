package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
//    @JsonView(Views.ForClient.class)
    private String passport_ser;
//    @JsonView(Views.ForClient.class)
    private String passport_num;
//    @JsonView(Views.ForClient.class)
    private String surname;

//    @JsonView(Views.ForClient.class)
    private String name;

//    @JsonView(Views.ForClient.class)
    private String phone;

//    @JsonIgnore
//    @JsonView(Views.ForClient.class)
    @JsonSerialize(using = ServicesSerializer.class)
    @OneToMany(mappedBy = "client") //название поля, которое сюда ссылается
    private List<ServiceItem> services;
}
