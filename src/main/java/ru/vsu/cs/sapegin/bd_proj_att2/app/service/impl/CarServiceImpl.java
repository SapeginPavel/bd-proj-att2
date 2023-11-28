package ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sapegin.bd_proj_att2.app.service.CarService;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.CarItem;
import ru.vsu.cs.sapegin.bd_proj_att2.item.repository.CarRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<CarItem> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public CarItem getCarById(int id) {
        return null;
    }

    @Override
    public CarItem getCarByRegNumber(String regNum) {
        return null;
    }

    @Override
    public void saveCar(CarItem newCar) {

    }

    @Override
    public void updateCar(int id, CarItem updatedCar) {

    }

    @Override
    public void deleteCar(int id) {

    }
}
