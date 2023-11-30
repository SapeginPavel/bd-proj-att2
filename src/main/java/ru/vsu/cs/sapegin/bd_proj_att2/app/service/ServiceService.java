package ru.vsu.cs.sapegin.bd_proj_att2.app.service;

import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

public interface ServiceService {
    List<ServiceItem> getAllServices(Integer clientId);

    ServiceItem getServiceById(int id);

//    public List<ServiceItem> getServicesForClientWithId(int clientId);

    void saveService(ServiceItem newService);

    void updateService(int id, ServiceItem updatedServiceDto);

    void deleteService(int id);
}
