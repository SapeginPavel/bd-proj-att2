package ru.vsu.cs.sapegin.bd_proj_att2.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sapegin.bd_proj_att2.api.ServiceApi;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.OffenseDto;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ServiceDto;
import ru.vsu.cs.sapegin.bd_proj_att2.app.mapper.ServiceMapper;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.ServiceService;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl.ServiceServiceImpl;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

@RestController("/services")
@RequiredArgsConstructor
public class ServiceController implements ServiceApi {

    private final ServiceServiceImpl serviceService;

    @Override
    public ResponseEntity<List<ServiceDto>> getAllServices() {
        List<ServiceItem> services = serviceService.getAllServices();
        return ResponseEntity.ok(ServiceMapper.INSTANCE.mapToDtos(services));
    }

    @Override
    public ResponseEntity<ServiceDto> getServiceById(int id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ServiceDto>> getServicesForClientWithId(int clientId) {
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
