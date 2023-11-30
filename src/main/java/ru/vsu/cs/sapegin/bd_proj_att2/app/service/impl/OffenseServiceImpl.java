package ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.OffenseDto;
import ru.vsu.cs.sapegin.bd_proj_att2.app.exception.NotFoundException;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.OffenseService;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.OffenseItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.repository.OffenseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OffenseServiceImpl implements OffenseService {

    private final OffenseRepository offenseRepository;

    @Override
    public List<OffenseItem> getAllOffenses() {
        return offenseRepository.findAll();
    }

    @Override
    public OffenseItem getOffenseById(int id) {
        return offenseRepository.findById(id).orElseThrow(() -> new NotFoundException("Offense with this id not found"));
    }

    @Override
    public List<OffenseItem> getOffensesForClientWithId(int clientId) {
        return null;
    }

    @Override
    public void addOffense(OffenseItem offenseItem) {
        offenseRepository.saveAndFlush(offenseItem);
    }

    @Override
    public void updateOffense(OffenseItem offenseItem) {
        addOffense(offenseItem);
    }

    @Override
    public void deleteOffense(int id) {
        offenseRepository.deleteById(id);
    }
}
