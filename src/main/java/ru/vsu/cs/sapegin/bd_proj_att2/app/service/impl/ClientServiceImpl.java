package ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.ClientService;
import ru.vsu.cs.sapegin.bd_proj_att2.app.exception.NotFoundException;
import ru.vsu.cs.sapegin.bd_proj_att2.item.repository.ClientRepository;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ClientItem;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<ClientItem> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientItem getClientById(int id) {
        return clientRepository.findById(id).orElseThrow(() -> new NotFoundException("Client with this id not found"));
    }

    @Override
    public List<ClientItem> getClientsBySurname(String surname) {
        //root("название поля в dto") _ сделать эти спецификации в getAll _ проверяем, что не null _ делаем спецификации _ объединяем их в одну через "or", "and"
        Specification<ClientItem> specification = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("surname"), surname);
        return clientRepository.findAll(specification);
//        return clientRepository.findAll().stream().filter(clientItem -> clientItem.getSurname().equals(surname)).collect(Collectors.toList()); //clientRepository.findBySurname(surname)
    }

    @Override
    public List<ClientItem> getClientByPhone(String phone) {
        return clientRepository.findAll().stream().filter(clientItem -> clientItem.getPhone().equals(phone)).toList();
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
