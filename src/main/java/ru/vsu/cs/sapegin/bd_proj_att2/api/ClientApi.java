package ru.vsu.cs.sapegin.bd_proj_att2.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;

import java.util.List;

@RequestMapping("/clients")
@Validated
//@CrossOrigin
public interface ClientApi {
    @GetMapping
    ResponseEntity<List<ClientDto>> getAllClients(
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String phone,
            @RequestParam(defaultValue = "0") Integer offset,
            @RequestParam(defaultValue = "25") @Max(25) Integer limit
    );

    @GetMapping("/{clientId}")
    ResponseEntity<ClientDto> getClientById(@PathVariable("clientId") int id );

    @PostMapping()
    ResponseEntity<ClientDto> addClient( @Valid @RequestBody ClientDto clientDto );

    @PutMapping("/{clientId}")
    ResponseEntity<ClientDto> updateClient( @PathVariable("clientId") int id, @Valid @RequestBody ClientDto clientDto );

    @DeleteMapping("/{clientId}")
    ResponseEntity<Void> deleteClient( @PathVariable("clientId") int id );
}
