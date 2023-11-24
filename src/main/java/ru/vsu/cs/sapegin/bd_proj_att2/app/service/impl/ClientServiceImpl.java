package ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.ClientService;
import ru.vsu.cs.sapegin.bd_proj_att2.app.exception.NotFoundException;
import ru.vsu.cs.sapegin.bd_proj_att2.item.ClientRepository;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<ClientItem> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientItem getClient(int id) {
        return clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with this id not found"));
    }

    @Override
    public ClientItem saveClient(int id) {
        return null;
    }

    @Override
    public ClientItem updateClient(int id) {
        return null;
    }

    @Override
    public void deleteClient(int id) {

    }
}
