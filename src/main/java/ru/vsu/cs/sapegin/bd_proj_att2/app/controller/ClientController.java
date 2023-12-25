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
    public ResponseEntity<List<ClientDto>> getAllClients(String surname, String phone, Integer offset, Integer limit) {
        List<ClientItem> allClients = clientService.getAllClientsWithPagination(surname, phone, offset, limit);
        List<ClientDto> clientDtos = ClientMapper.INSTANCE.mapToDtos(allClients);
        //ClientDto last = clientDtos.get(clientDtos.size() - 1);

        //last.setHasNextPageForPagination(true);
        return ResponseEntity.ok(clientDtos);
    }

    @Override
    public ResponseEntity<ClientDto> getClientById(int id) {
        ClientItem client = clientService.getClientById(id);
        return ResponseEntity.ok(ClientMapper.INSTANCE.mapToDto(client));
    }

    @Override
    public ResponseEntity<ClientDto> addClient(ClientDto clientDto) {
        ClientItem clientItem = ClientMapper.INSTANCE.mapToItem(clientDto);
        clientService.saveClient(clientItem);
        return ResponseEntity.ok(ClientMapper.INSTANCE.mapToDto(clientItem));
    }

    @Override
    public ResponseEntity<ClientDto> updateClient(int id, ClientDto clientDto) {

        ClientItem currentClient = clientService.getClientById(id);
        currentClient.setName(clientDto.getName());
        currentClient.setSurname(clientDto.getSurname());
        currentClient.setPhone(clientDto.getPhone());
        currentClient.setPassport_num(clientDto.getPassport_num());
        currentClient.setPassport_ser(clientDto.getPassport_ser());

        clientService.updateClient(currentClient);

        return ResponseEntity.ok(ClientMapper.INSTANCE.mapToDto(currentClient));
    }

    @Override
    public ResponseEntity<Void> deleteClient(int id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
