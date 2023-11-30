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
    public ResponseEntity<OffenseDto> getOffenseById(int id) {
        OffenseItem offenseItem = offenseService.getOffenseById(id);
        return ResponseEntity.ok(OffenseMapper.INSTANCE.mapToDto(offenseItem));
    }

    @Override
    public ResponseEntity<Void> addOffense(OffenseDto offenseDto) {
        OffenseItem offenseItem = OffenseMapper.INSTANCE.mapToItem(offenseDto);
        offenseService.addOffense(offenseItem);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateOffense(int id, OffenseDto offenseDto) {
        OffenseItem currentOffenseItem = offenseService.getOffenseById(id);
        if (offenseDto.getFine() != 0) {
            currentOffenseItem.setFine(offenseDto.getFine());
        }
        if (offenseDto.getProblem() != null) {
            currentOffenseItem.setProblem(offenseDto.getProblem());
        }
//        if (updatedServiceDto.getOffenses() != null) {
//            List<OffenseItem> newOffenses = OffenseMapper.INSTANCE.mapToItems(updatedServiceDto.getOffenses());
//            oldServiceItem.getOffenses().addAll(newOffenses);
//        }
        offenseService.updateOffense(currentOffenseItem);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<OffenseDto> deleteOffense(int id) {
        offenseService.deleteOffense(id);
        return ResponseEntity.ok().build();
    }
}
