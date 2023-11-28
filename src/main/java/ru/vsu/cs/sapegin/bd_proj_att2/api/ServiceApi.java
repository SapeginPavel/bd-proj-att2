package ru.vsu.cs.sapegin.bd_proj_att2.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.OffenseDto;
import ru.vsu.cs.sapegin.bd_proj_att2.item.model.ServiceItem;

import java.util.List;

@RequestMapping("/services")
public interface ServiceApi {

    @GetMapping
    ResponseEntity<List<ServiceItem>> getAllServices();

    @GetMapping("/id={offense_id}")
    ResponseEntity<ServiceItem> getServiceById( @PathVariable("offense_id") int id );

    @GetMapping("/id={client_id}")
    ResponseEntity<List<ServiceItem>> getServicesForClientWithId(@PathVariable("client_id") int clientId );

    @PostMapping
    ResponseEntity<Void> addOffense( @RequestBody OffenseDto offenseDto );

    @PutMapping("/id={offense_id}")
    ResponseEntity<Void> updateOffense( @PathVariable("offense_id") int id, @RequestBody OffenseDto updatedOffenseDto);

    @DeleteMapping("id={offense_id}")
    ResponseEntity<Void> deleteOffense( @PathVariable("offense_id") int id);
}
