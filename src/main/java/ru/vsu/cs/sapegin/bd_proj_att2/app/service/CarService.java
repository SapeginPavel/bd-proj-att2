package ru.vsu.cs.sapegin.bd_proj_att2.app.service;

import ru.vsu.cs.sapegin.bd_proj_att2.item.model.CarItem;

import java.util.List;

public interface CarService {
    public List<CarItem> getAllCars();

    public CarItem getCarById(int id);

    public List<CarItem> getCarByRegNumber(String regNum);

    public void saveCar(CarItem newCar);

    public void updateCar(int id, CarItem updatedCar);

    public void deleteCar(int id);
}
