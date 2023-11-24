package ru.vsu.cs.sapegin.bd_proj_att2.app.service;

import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;

import java.util.List;

public interface ClientService {
    List<ClientItem> getAllClients();
    ClientItem getClient(int id);

    ClientItem saveClient(int id);

    ClientItem updateClient(int id);

    void deleteClient(int id);
}