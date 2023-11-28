package ru.vsu.cs.sapegin.bd_proj_att2.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.CarDto;

import java.util.List;

@RequestMapping("/cars")
public interface CarApi {

    @GetMapping
    ResponseEntity<List<CarDto>> getAllCars();

    @GetMapping("id={car_id}")
    ResponseEntity<CarDto> getCarById( @PathVariable("car_id") int id );

    @GetMapping("reg={regNum}")
    ResponseEntity<CarDto> getCarByRegNumber( @PathVariable("regNum") String regNum );

    @PostMapping
    ResponseEntity<Void> addCar( @RequestBody CarDto carDto );

    @PutMapping
    ResponseEntity<Void> updateCar( @RequestBody CarDto carDto );

    @DeleteMapping("id={car_id}")
    ResponseEntity<Void> deleteCar( @PathVariable("car_id") int id);
}
