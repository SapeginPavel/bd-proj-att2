package ru.vsu.cs.sapegin.bd_proj_att2.app.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sapegin.bd_proj_att2.api.ClientApi;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.special.ClientDtoServicesAsId;
import ru.vsu.cs.sapegin.bd_proj_att2.app.Views;
import ru.vsu.cs.sapegin.bd_proj_att2.app.mapper.ClientMapper;
import ru.vsu.cs.sapegin.bd_proj_att2.app.mapper.special.ClientMapperSpecial;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl.ClientServiceImpl;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController implements ClientApi {

    //todo: сделать защиту, чтобы нельзя было ввести неправильно dto
    private final ClientServiceImpl clientService;

//    @JsonView(Views.ForClient.class)
    @Override
    public ResponseEntity<List<ClientDto>> getAllClients(String surname, String phone) {
        List<ClientItem> allClients = clientService.getAllClients(surname, phone);
        return ResponseEntity.ok(ClientMapper.INSTANCE.mapToDtos(allClients)); //возвращает HTTP-ответ со статусом 200 и телом ответа, содержащим преобразованные объекты Dto
    }

//    @JsonView(Views.ForClient.class)
    @Override
    public ResponseEntity<ClientDto> getClientById(int id) {
        System.out.println("Хотя бы зашли");
        ClientItem client = clientService.getClientById(id);
        System.out.println("Вытащили из БД: " + client);
        System.out.println("После маппинга: " + ClientMapper.INSTANCE.mapToDto(client));
        return ResponseEntity.ok(ClientMapper.INSTANCE.mapToDto(client));
    }

    @Override
    public ResponseEntity<ClientDto> addClient(ClientDto clientDto) {
        System.out.println("Добавляем в базу: " + clientDto);
        ClientItem clientItem = ClientMapper.INSTANCE.mapToItem(clientDto);
        clientService.saveClient(clientItem);
        return ResponseEntity.ok(ClientMapper.INSTANCE.mapToDto(clientItem));
    }

    @Override
    public ResponseEntity<ClientDto> updateClient(int id, ClientDto clientDto) {

        System.out.println("Пришло для обновления: " + clientDto);

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
