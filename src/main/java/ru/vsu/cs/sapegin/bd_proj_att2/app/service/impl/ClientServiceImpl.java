package ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.ClientService;
import ru.vsu.cs.sapegin.bd_proj_att2.app.exception.NotFoundException;
import ru.vsu.cs.sapegin.bd_proj_att2.item.ClientRepository;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<ClientItem> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientItem getClientById(int id) {
        return clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with this id not found"));
    }

    @Override
    public List<ClientItem> getClientsBySurname(String surname) {
        return clientRepository.findAll().stream().filter(clientItem -> clientItem.getSurname().equals(surname)).collect(Collectors.toList()); //clientRepository.findBySurname(surname)
    }

    @Override
    public List<ClientItem> getClientByPhone(String phone) {
        return clientRepository.findAll().stream().filter(clientItem -> clientItem.getPhone().equals(phone)).toList();
    }

    @Override
    public void saveClient(ClientItem newClient) {
        clientRepository.saveAndFlush(newClient);
    }

    @Override
    public void updateClient(int id, ClientItem updatedClient) {
        //todo: нет нормального обновления
    }

    @Override
    public void deleteClient(int id) {
        clientRepository.delete(getClientById(id));
    }
}
