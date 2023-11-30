package ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sapegin.bd_proj_att2.app.exception.NotFoundClientExc;
import ru.vsu.cs.sapegin.bd_proj_att2.app.exception.NotFoundException;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.ServiceService;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.repository.ClientRepository;
import ru.vsu.cs.sapegin.bd_proj_att2.item.repository.ServiceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;
    private final ClientRepository clientRepository;

    @Override
    public List<ServiceItem> getAllServices(Integer clientId) {
        if (clientId != null) {
            ClientItem client = clientRepository.findById(clientId).orElseThrow(NotFoundClientExc::new);
            Specification<ServiceItem> specification = ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("client"), client));
            return serviceRepository.findAll(specification);
        }
        return serviceRepository.findAll();
    }

    @Override
    public ServiceItem getServiceById(int id) {
        return serviceRepository.findById(id).orElseThrow(() -> new NotFoundException("Offense with this id not found"));
    }

    @Override
    public void saveService(ServiceItem newService) {
        serviceRepository.saveAndFlush(newService);
    }

    @Override
    public void updateService(int id, ServiceItem updatedServiceDto) {
        saveService(updatedServiceDto);
    }

    @Override
    public void deleteService(int id) {
        serviceRepository.deleteById(id);
    }
}
