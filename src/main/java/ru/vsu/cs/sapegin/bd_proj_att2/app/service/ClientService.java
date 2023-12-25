package ru.vsu.cs.sapegin.bd_proj_att2.app.service;

import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;

import java.util.List;

public interface ClientService {
    List<ClientItem> getAllClientsWithPagination(String surname, String phone, Integer offset, Integer limit);
    ClientItem getClientById(int id);

    void saveClient(ClientItem clientItem);

    void updateClient(ClientItem clientItem);

    void deleteClient(int id);
}
