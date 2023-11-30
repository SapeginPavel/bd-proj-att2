package ru.vsu.cs.sapegin.bd_proj_att2.app.service;

import ru.vsu.cs.sapegin.bd_proj_att2.api.model.OffenseDto;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.OffenseItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

public interface OffenseService {
    List<OffenseItem> getAllOffenses();

    OffenseItem getOffenseById(int id);

    List<OffenseItem> getOffensesForClientWithId(int clientId);

    void addOffense(OffenseItem offenseItem);

    void updateOffense(int id, OffenseDto offenseDto);

    void deleteOffense(int id);
}
