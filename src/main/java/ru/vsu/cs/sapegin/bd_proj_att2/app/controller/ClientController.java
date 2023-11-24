package ru.vsu.cs.sapegin.bd_proj_att2.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sapegin.bd_proj_att2.api.ClientApi;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;

import java.util.List;

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
