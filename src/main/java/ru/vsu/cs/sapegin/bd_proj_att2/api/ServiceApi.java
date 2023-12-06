package ru.vsu.cs.sapegin.bd_proj_att2.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ServiceDto;

import java.util.List;

@RequestMapping("/services")
public interface ServiceApi {

    @GetMapping
    ResponseEntity<List<ServiceDto>> getAllServices( @RequestParam(required = false) Integer client_id);

    @GetMapping("/{service_id}")
    ResponseEntity<ServiceDto> getServiceById( @PathVariable("service_id") int id );

    @PostMapping
    ResponseEntity<ServiceDto> addService( @RequestBody ServiceDto ServiceDto );

    @PutMapping("/{service_id}")
    ResponseEntity<ServiceDto> updateService( @PathVariable("service_id") int id, @RequestBody ServiceDto updatedServiceDto);

    @DeleteMapping("{service_id}")
    ResponseEntity<Void> deleteService( @PathVariable("service_id") int id);
}
