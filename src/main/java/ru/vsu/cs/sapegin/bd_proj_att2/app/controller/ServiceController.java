package ru.vsu.cs.sapegin.bd_proj_att2.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sapegin.bd_proj_att2.api.ServiceApi;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.OffenseDto;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ServiceDto;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

@RestController
public class ServiceController implements ServiceApi {
    @Override
    public ResponseEntity<List<ServiceItem>> getAllServices() {
        return null;
    }

    @Override
    public ResponseEntity<ServiceItem> getServiceById(int id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ServiceItem>> getServicesForClientWithId(int clientId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> addService(ServiceDto ServiceDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateService(int id, ServiceDto updatedServiceDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteService(int id) {
        return null;
    }
}
