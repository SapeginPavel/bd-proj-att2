package ru.vsu.cs.sapegin.bd_proj_att2.api;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;
import ru.vsu.cs.sapegin.bd_proj_att2.app.Views;

import java.util.List;

@RequestMapping("/clients")
//@CrossOrigin
public interface ClientApi {
    @GetMapping
    ResponseEntity<List<ClientDto>> getAllClients( @RequestParam(required = false) String surname, @RequestParam(required = false) String phone ); //@RequestParam(required = false) String surname

    @GetMapping("/{clientId}")
    ResponseEntity<ClientDto> getClientById( @PathVariable("clientId") int id );

    @PostMapping()
    ResponseEntity<Void> addClient( @RequestBody ClientDto clientDto );

    @PutMapping("/{clientId}")
    ResponseEntity<Void> updateClient( @PathVariable("clientId") int id, @RequestBody ClientDto clientDto );

    @DeleteMapping("/{clientId}")
    ResponseEntity<Void> deleteClient( @PathVariable("clientId") int id );
}
