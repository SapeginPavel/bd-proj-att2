package ru.vsu.cs.sapegin.bd_proj_att2.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.ClientDto;

import java.util.List;

@RequestMapping("/clients")
public interface ClientApi {
    @GetMapping
    ResponseEntity<List<ClientDto>> getAllClients();

    @GetMapping("/id={clientId}")
    ResponseEntity<ClientDto> getClientById( @PathVariable("clientId") int id );

    @GetMapping("/surname={surname}")
    ResponseEntity<ClientDto> getClientBySurname( @PathVariable("surname") String surname );

    @GetMapping("/phone={phone}")
    ResponseEntity<ClientDto> getClientByPhone( @PathVariable("phone") String phone );
}
