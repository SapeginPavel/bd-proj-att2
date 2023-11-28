package ru.vsu.cs.sapegin.bd_proj_att2.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.sapegin.bd_proj_att2.api.CarApi;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.CarDto;
import ru.vsu.cs.sapegin.bd_proj_att2.app.mapper.CarMapper;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl.CarServiceImpl;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.CarItem;

import java.sql.SQLOutput;
import java.util.List;

@RestController
@RequiredArgsConstructor //нужен, чтобы спринг бут внедрил carService
public class CarController implements CarApi {

    private final CarServiceImpl carService;

    @Override
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarItem> allCars = carService.getAllCars();
        return ResponseEntity.ok(CarMapper.INSTANCE.mapToDtos(allCars));
    }

    @Override
    public ResponseEntity<CarDto> getCarById(int id) {
        CarItem carItem = carService.getCarById(id);
        return ResponseEntity.ok(CarMapper.INSTANCE.mapToDto(carItem));
    }

    @Override
    public ResponseEntity<List<CarDto>> getCarByRegNumber(String regNum) {
        List<CarItem> carItems = carService.getCarByRegNumber(regNum);
        return ResponseEntity.ok(CarMapper.INSTANCE.mapToDtos(carItems));
    }

    @Override
    public ResponseEntity<Void> addCar(CarDto carDto) {
        CarItem carItem = CarMapper.INSTANCE.mapToItem(carDto);
        carService.saveCar(carItem);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateCar(int id, CarDto carDto) {
        CarItem updatedCar = carService.getCarById(id);
        updatedCar.setReg_number(carDto.getReg_number());
        carService.updateCar(id, updatedCar);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteCar(int id) {
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }
}
