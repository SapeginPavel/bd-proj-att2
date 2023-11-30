package ru.vsu.cs.sapegin.bd_proj_att2.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.sapegin.bd_proj_att2.api.model.OffenseDto;

import java.util.List;

@RequestMapping("/offenses")
public interface OffenseApi {

    @GetMapping
    ResponseEntity<List<OffenseDto>> getAllOffenses();

    @GetMapping("/{offense_id}")
    ResponseEntity<OffenseDto> getAllOffenses(@PathVariable("offense_id") int id);

    @PostMapping("/{offense_id}")
    ResponseEntity<Void> addOffense(@RequestBody OffenseDto offenseDto);

    @PutMapping("/{offense_id}")
    ResponseEntity<Void> updateOffense(@PathVariable("offense_id") int id, @RequestBody OffenseDto offenseDto);

    @DeleteMapping("/{offense_id}")
    ResponseEntity<OffenseDto> deleteOffense(@PathVariable("offense_id") int id);

}
