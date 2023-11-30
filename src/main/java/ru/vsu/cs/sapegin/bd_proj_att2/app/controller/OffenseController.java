package ru.vsu.cs.sapegin.bd_proj_att2.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sapegin.bd_proj_att2.api.OffenseApi;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.OffenseDto;
import ru.vsu.cs.sapegin.bd_proj_att2.app.mapper.OffenseMapper;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.OffenseService;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.OffenseItem;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OffenseController implements OffenseApi {

    private final OffenseService offenseService;

    @Override
    public ResponseEntity <List<OffenseDto>> getAllOffenses() {
        List<OffenseItem> offenseItems = offenseService.getAllOffenses();
        return ResponseEntity.ok(OffenseMapper.INSTANCE.mapToDtos(offenseItems));
    }

    @Override
    public ResponseEntity<OffenseDto> getAllOffenses(int id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> addOffense(OffenseDto offenseDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateOffense(int id, OffenseDto offenseDto) {
        return null;
    }

    @Override
    public ResponseEntity<OffenseDto> deleteOffense(int id) {
        return null;
    }
}
