package ru.vsu.cs.sapegin.bd_proj_att2.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sapegin.bd_proj_att2.api.ClientApi;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;
import ru.vsu.cs.sapegin.bd_proj_att2.app.mapper.ClientMapper;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl.ClientServiceImpl;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController implements ClientApi {

    private final ClientServiceImpl clientService;

    @Override
    public ResponseEntity<List<ClientDto>> getAllClients() {
        System.out.println("Немножко работает!");
        List<ClientItem> allClients = clientService.getAllClients();
        return ResponseEntity.ok(ClientMapper.INSTANCE.mapToDtos(allClients)); //возвращает HTTP-ответ со статусом 200 и телом ответа, содержащим преобразованные объекты Dto
    }

    @Override
    public ResponseEntity<ClientDto> getClientById(int id) {
        ClientItem client = clientService.getClientById(id);
        return ResponseEntity.ok(ClientMapper.INSTANCE.mapToDto(client));
    }

    @Override
    public ResponseEntity<List<ClientDto>> getClientBySurname(String surname) {
        List<ClientItem> clients = clientService.getClientsBySurname(surname);
        return ResponseEntity.ok(ClientMapper.INSTANCE.mapToDtos(clients));
    }

    @Override
    public ResponseEntity<ClientDto> getClientByPhone(String phone) {
        return null;
    }
}
