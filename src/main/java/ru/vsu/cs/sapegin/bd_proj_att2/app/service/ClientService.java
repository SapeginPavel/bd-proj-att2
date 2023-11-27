package ru.vsu.cs.sapegin.bd_proj_att2.app.service;

import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;

import java.util.List;

public interface ClientService {
    List<ClientItem> getAllClients();
    ClientItem getClientById(int id);

    List<ClientItem> getClientsBySurname(String surname);

    List<ClientItem> getClientByPhone(String phone);

    void saveClient(ClientItem clientItem);

    void updateClient(int id, ClientItem clientItem);

    void deleteClient(int id);
}
