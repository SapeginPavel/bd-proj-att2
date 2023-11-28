package ru.vsu.cs.sapegin.bd_proj_att2.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.sapegin.bd_proj_att2.app.exception.NotFoundException;
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
        return carRepository.findById(id).orElseThrow(() -> new NotFoundException("Car with this id not found"));
    }

    @Override
    public List<CarItem> getCarByRegNumber(String regNum) {
        return carRepository.findAll().stream().filter(carItem -> carItem.getReg_number().equals(regNum)).toList();
    }

    @Override
    public void saveCar(CarItem newCar) {
        carRepository.saveAndFlush(newCar);
    }

    @Override
    public void updateCar(int id, CarItem updatedCar) {
        saveCar(updatedCar);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }
}
