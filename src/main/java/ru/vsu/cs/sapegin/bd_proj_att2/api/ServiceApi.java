package ru.vsu.cs.sapegin.bd_proj_att2.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.OffenseDto;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ServiceDto;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

@RequestMapping("/services")
public interface ServiceApi {

    @GetMapping
    ResponseEntity<List<ServiceItem>> getAllServices();

    @GetMapping("/id={service_id}")
    ResponseEntity<ServiceItem> getServiceById( @PathVariable("service_id") int id );

    @GetMapping("/id={client_id}")
    ResponseEntity<List<ServiceItem>> getServicesForClientWithId(@PathVariable("client_id") int clientId );

    @PostMapping
    ResponseEntity<Void> addService( @RequestBody ServiceDto ServiceDto );

    @PutMapping("/id={service_id}")
    ResponseEntity<Void> updateService( @PathVariable("service_id") int id, @RequestBody ServiceDto updatedServiceDto);

    @DeleteMapping("id={service_id}")
    ResponseEntity<Void> deleteService( @PathVariable("service_id") int id);
}
