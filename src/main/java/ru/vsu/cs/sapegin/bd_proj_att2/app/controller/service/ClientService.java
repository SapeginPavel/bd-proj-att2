package ru.vsu.cs.sapegin.bd_proj_att2.app.controller.service;

import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;

import java.util.List;

public interface ClientService {
    List<ClientItem> getAllClients();
    ClientItem getClientById(int id);
}
