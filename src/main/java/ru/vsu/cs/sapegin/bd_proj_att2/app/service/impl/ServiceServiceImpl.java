package ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.OffenseDto;
import ru.vsu.cs.sapegin.bd_proj_att2.app.exception.NotFoundException;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.ServiceService;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.OffenseItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.repository.ServiceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public List<ServiceItem> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public ServiceItem getServiceById(int id) {
        return serviceRepository.findById(id).orElseThrow(() -> new NotFoundException("Offense with this id not found"));
    }

    @Override
    public List<ServiceItem> getServicesForClientWithId(int clientId) {

        return null;
    }

    @Override
    public void addOffense(OffenseItem newOffense) {

    }

    @Override
    public void updateOffense(int id, OffenseDto updatedOffenseDto) {

    }

    @Override
    public void deleteOffense(int id) {

    }
}
