package ru.vsu.cs.sapegin.bd_proj_att2.item.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import ru.vsu.cs.sapegin.bd_proj_att2.app.Views;

import java.util.List;

@Entity
@Table(name = "client")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "client_id")
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

    @JsonIgnore
    @OneToMany(mappedBy = "client") //название поля, которое сюда ссылается
    private List<ServiceItem> services;
}
