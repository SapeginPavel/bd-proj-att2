package ru.vsu.cs.sapegin.bd_proj_att2.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;

import java.util.List;

@RequestMapping("/clients")
public interface ClientApi {
    @GetMapping
    ResponseEntity<List<ClientDto>> getAllClients(); //@RequestParam(required = false) String surname

    @GetMapping("/id={clientId}")
    ResponseEntity<ClientDto> getClientById( @PathVariable("clientId") int id );

    @GetMapping("/surname={surname}")
    ResponseEntity<List<ClientDto>> getClientBySurname( @PathVariable("surname") String surname );

    @GetMapping("/phone={phone}")
    ResponseEntity<List<ClientDto>> getClientByPhone( @PathVariable("phone") String phone );

    @PostMapping()
    ResponseEntity<Void> addClient( @RequestBody ClientDto clientDto );

    @PutMapping("/id={clientId}")
    ResponseEntity<Void> updateClient( @PathVariable("clientId") int id, @RequestBody ClientDto clientDto );

    @DeleteMapping("/id={clientId}")
    ResponseEntity<Void> deleteClient( @PathVariable("clientId") int id );
}
