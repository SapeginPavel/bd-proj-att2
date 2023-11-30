package ru.vsu.cs.sapegin.bd_proj_att2.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.CarDto;

import java.util.List;

@RequestMapping("/cars")
public interface CarApi {

    @GetMapping
    ResponseEntity<List<CarDto>> getAllCars( @RequestParam(required = false) String reg );

    @GetMapping("/{car_id}")
    ResponseEntity<CarDto> getCarById( @PathVariable("car_id") int id );

    @PostMapping
    ResponseEntity<Void> addCar( @RequestBody CarDto carDto );

    @PutMapping("/{car_id}")
    ResponseEntity<Void> updateCar( @PathVariable("car_id") int id, @RequestBody CarDto carDto );

    @DeleteMapping("/{car_id}")
    ResponseEntity<Void> deleteCar( @PathVariable("car_id") int id );
}
