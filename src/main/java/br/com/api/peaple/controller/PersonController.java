package br.com.api.peaple.controller;

import br.com.api.peaple.dtos.request.PersonRequestDto;
import br.com.api.peaple.dtos.response.PersonResponseDto;
import br.com.api.peaple.service.PersonServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/peaple")
public class PersonController {

    private final PersonServiceImpl personService;

    @PostMapping
    public ResponseEntity<PersonResponseDto> save(@Valid @RequestBody PersonRequestDto dto){
        return ResponseEntity.ok(personService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<PersonResponseDto>> findAll(){
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("/mapper")
    public ResponseEntity<List<PersonResponseDto>> findAllWithMapper(){
        return ResponseEntity.ok(personService.findAllWithMapper());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(personService.findById(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PersonResponseDto> update(@PathVariable Long id, @Valid @RequestBody PersonRequestDto dto){
        return ResponseEntity.ok(personService.update(id, dto));

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(personService.delete(id));
    }

}
