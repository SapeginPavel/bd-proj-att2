package ru.vsu.cs.sapegin.bd_proj_att2.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sapegin.bd_proj_att2.api.ServiceApi;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ServiceDto;
import ru.vsu.cs.sapegin.bd_proj_att2.app.mapper.OffenseMapper;
import ru.vsu.cs.sapegin.bd_proj_att2.app.mapper.ServiceMapper;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl.CarServiceImpl;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl.ClientServiceImpl;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl.ServiceServiceImpl;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.OffenseItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

@RestController("/services")
@RequiredArgsConstructor
public class ServiceController implements ServiceApi {
    private final ServiceServiceImpl serviceService;
    private final CarServiceImpl carService;
    private final ClientServiceImpl clientService;

    @Override
    public ResponseEntity<List<ServiceDto>> getAllServices(Integer client_id) {
        List<ServiceItem> services = serviceService.getAllServices(client_id);
        return ResponseEntity.ok(ServiceMapper.INSTANCE.mapToDtos(services));
    }

    @Override
    public ResponseEntity<ServiceDto> getServiceById(int id) {
        ServiceItem serviceItem = serviceService.getServiceById(id);
        return ResponseEntity.ok(ServiceMapper.INSTANCE.mapToDto(serviceItem));
    }

    @Override
    public ResponseEntity<Void> addService(ServiceDto serviceDto) {
        ServiceItem newService = ServiceMapper.INSTANCE.mapToItem(serviceDto);
        newService.setCar(carService.getCarById(serviceDto.getCar().getCar_id()));
        newService.setClient(clientService.getClientById(serviceDto.getClient().getClient_id()));
        serviceService.saveService(newService);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateService(int id, ServiceDto updatedServiceDto) {
        ServiceItem oldServiceItem = serviceService.getServiceById(id);

        if (updatedServiceDto.getStartDate() != null) {
            oldServiceItem.setStartDate(updatedServiceDto.getStartDate());
        }
        if (updatedServiceDto.getEndDate() != null) {
            oldServiceItem.setEndDate(updatedServiceDto.getEndDate());
        }

        if (updatedServiceDto.getCar() != null) {
            oldServiceItem.setCar(carService.getCarById(updatedServiceDto.getCar().getCar_id()));
        }
        if (updatedServiceDto.getClient() != null) {
            oldServiceItem.setClient(clientService.getClientById(updatedServiceDto.getClient().getClient_id()));
        }

        if (updatedServiceDto.getOffenses() != null) {
            List<OffenseItem> newOffenses = OffenseMapper.INSTANCE.mapToItems(updatedServiceDto.getOffenses());
            oldServiceItem.getOffenses().addAll(newOffenses);
        }

        serviceService.updateService(id, oldServiceItem);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteService(int id) {
        serviceService.deleteService(id);
        return ResponseEntity.ok().build();
    }
}
