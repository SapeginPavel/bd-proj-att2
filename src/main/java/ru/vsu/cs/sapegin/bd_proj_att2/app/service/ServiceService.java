package ru.vsu.cs.sapegin.bd_proj_att2.app.service;

import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

public interface ServiceService {
    public List<ServiceItem> getAllServices();

    public ServiceItem getServiceById(int id);

    public List<ServiceItem> getServicesForClientWithId(int clientId);

    public void addService(ServiceItem newService);

    public void updateService(int id, ServiceItem updatedServiceDto);

    public void deleteService(int id);
}
