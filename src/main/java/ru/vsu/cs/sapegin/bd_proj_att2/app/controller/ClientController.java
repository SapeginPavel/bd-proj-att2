package ru.vsu.cs.sapegin.bd_proj_att2.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sapegin.bd_proj_att2.api.ClientApi;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;
import ru.vsu.cs.sapegin.bd_proj_att2.app.mapper.ClientMapper;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl.ClientServiceImpl;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController implements ClientApi {

    private final ClientServiceImpl clientService;

//    @Override
//    public ResponseEntity<List<ClientDto>> getAllClients() {
//        List<ClientItem> allClients = clientService.getAllClients();
//        return ResponseEntity.ok(ClientMapper.INSTANCE.mapToDtos(allClients)); //возвращает HTTP-ответ со статусом 200 и телом ответа, содержащим преобразованные объекты Dto
//    }

    @Override
    public ResponseEntity<List<ClientDto>> getAllClients(String surname, String phone) {
        List<ClientItem> allClients = clientService.getAllClients(surname, phone);
        return ResponseEntity.ok(ClientMapper.INSTANCE.mapToDtos(allClients)); //возвращает HTTP-ответ со статусом 200 и телом ответа, содержащим преобразованные объекты Dto
    }

    @Override
    public ResponseEntity<ClientDto> getClientById(int id) {
        ClientItem client = clientService.getClientById(id);
        ClientDto clientDto = ClientMapper.INSTANCE.mapToDto(client);
        clientDto.setClient_id(10);
        return ResponseEntity.ok(ClientMapper.INSTANCE.mapToDto(client));
    }

//    @Override
//    public ResponseEntity<List<ClientDto>> getClientBySurname(String surname) {
//        List<ClientItem> clients = clientService.getClientsBySurname(surname);
//        return ResponseEntity.ok(ClientMapper.INSTANCE.mapToDtos(clients));
//    }
//
//    @Override
//    public ResponseEntity<List<ClientDto>> getClientByPhone(String phone) {
//        List<ClientItem> clients = clientService.getClientByPhone(phone);
//        return ResponseEntity.ok(ClientMapper.INSTANCE.mapToDtos(clients));
//    }

    @Override
    public ResponseEntity<Void> addClient(ClientDto clientDto) {
        ClientItem clientItem = ClientMapper.INSTANCE.mapToItem(clientDto);
        clientService.saveClient(clientItem);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateClient(int id, ClientDto clientDto) {
        ClientItem updatedClient = ClientMapper.INSTANCE.mapToItem(clientDto);

        ClientItem currentClient = clientService.getClientById(id);
        currentClient.setName(updatedClient.getName());
        currentClient.setSurname(updatedClient.getSurname());
        currentClient.setPhone(updatedClient.getPhone());
        currentClient.setPassport_num(updatedClient.getPassport_num());
        currentClient.setPassport_ser(updatedClient.getPassport_ser());

        clientService.updateClient(updatedClient);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteClient(int id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
