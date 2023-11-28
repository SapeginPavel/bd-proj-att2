package ru.vsu.cs.sapegin.bd_proj_att2.app.service;

import ru.vsu.cs.sapegin.bd_proj_att2.api.model.OffenseDto;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.OffenseItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

public interface OffenseService {
    public List<ServiceItem> getAllServices();

    public ServiceItem getServiceById(int id);

    public List<ServiceItem> getServicesForClientWithId(int clientId);

    public void addOffense(OffenseItem newOffense);

    public void updateOffense(int id, OffenseDto updatedServiceDto);

    public void deleteOffense(int id);
}
