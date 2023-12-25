package ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sapegin.bd_proj_att2.app.Views;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.ClientService;
import ru.vsu.cs.sapegin.bd_proj_att2.app.exception.NotFoundException;
import ru.vsu.cs.sapegin.bd_proj_att2.item.repository.ClientRepository;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<ClientItem> getAllClientsWithPagination(String surname, String phone, Integer offset, Integer limit) {
        List<Specification<ClientItem>> specifications = new ArrayList<>();
        if (surname != null) {
            Specification<ClientItem> specification = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("surname"), surname);
            specifications.add(specification);
        }
        if (phone != null) {
            Specification<ClientItem> specification = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("phone"), phone);
            specifications.add(specification);
        }

        offset = offset == null ? 0 : offset;
        limit = limit == null ? 15 : limit;

        if (specifications.size() == 0) {
            return clientRepository.findAll(PageRequest.of(offset, limit, Sort.by(Sort.Direction.ASC, "clientId"))).stream().toList();
        } else if (specifications.size() == 1) {
            return clientRepository.findAll(specifications.get(0), PageRequest.of(offset, limit, Sort.by(Sort.Direction.ASC, "clientId"))).stream().toList();
        } else {
            Specification<ClientItem> defaultSpec = specifications.get(0);
            for (int i = 1; i < specifications.size(); i++) {
                defaultSpec = defaultSpec.and(specifications.get(i));
            }
            PageRequest preq = PageRequest.of(offset, limit, Sort.by(Sort.Direction.ASC, "clientId"));
            System.out.println(preq.next() == null);
            return clientRepository.findAll(defaultSpec, preq).stream().toList();
        }
    }

    @Override
    public ClientItem getClientById(int id) {
        return clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with this id not found"));
    }

    @Override
    public void saveClient(ClientItem newClient) {
        clientRepository.saveAndFlush(newClient);
    }

    @Override
    public void updateClient(ClientItem updatedClient) {
        clientRepository.saveAndFlush(updatedClient);
    }

    @Override
    public void deleteClient(int id) {
        clientRepository.delete(getClientById(id));
    }
}
