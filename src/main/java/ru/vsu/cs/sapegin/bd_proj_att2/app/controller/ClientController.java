package ru.vsu.cs.sapegin.bd_proj_att2.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sapegin.bd_proj_att2.api.ClientApi;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;

import java.util.List;

//todo: если не запустится, то проверить классы Item (правильно ли там указана таблица)
//Пока всё только для Client (ещё для Service)
//todo: остановился на Мапперах (понять, что это такое)

@RestController
public class ClientController implements ClientApi {

    @Override
    public ResponseEntity<List<ClientDto>> getAllClients() {
        return null;
    }

    @Override
    public ResponseEntity<ClientDto> getClientById(int id) {

        return null;
    }
}
