package ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.ClientService;
import ru.vsu.cs.sapegin.bd_proj_att2.app.exception.NotFoundException;
import ru.vsu.cs.sapegin.bd_proj_att2.item.repository.ClientRepository;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<ClientItem> getAllClients(String surname, String phone) {
        List<Specification<ClientItem>> specifications = new ArrayList<>();
        if (surname != null) {
            Specification<ClientItem> specification = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("surname"), surname);
            specifications.add(specification);
        }
        if (phone != null) {
            Specification<ClientItem> specification = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("phone"), phone);
            specifications.add(specification);
        }

        if (specifications.size() == 0) {
            return clientRepository.findAll();
        } else if (specifications.size() == 1) {
            return clientRepository.findAll(specifications.get(0));
        } else {
            Specification<ClientItem> defaultSpec = specifications.get(0);
            for (int i = 1; i < specifications.size(); i++) {
                defaultSpec = defaultSpec.and(specifications.get(i));
            }
            return clientRepository.findAll(defaultSpec);
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
        //todo: нет нормального обновления
        //Почему бы не сделать так: если у нас одинаковые везде операции, то можно сделать общий интерфейс, где будут "добавить", "обновить" и тд
        clientRepository.saveAndFlush(updatedClient);
    }

    @Override
    public void deleteClient(int id) {
        clientRepository.delete(getClientById(id));
    }
}
