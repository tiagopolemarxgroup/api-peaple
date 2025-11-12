package br.com.api.peaple.service;

import br.com.api.peaple.dtos.request.PersonRequestDto;
import br.com.api.peaple.dtos.response.PersonResponseDto;

import java.util.List;

public interface PersonService {

    PersonResponseDto save(PersonRequestDto dto);
    PersonResponseDto findById(Long id);
    List<PersonResponseDto> findAll();
    PersonResponseDto update(Long id, PersonRequestDto dto);
    String delete(Long id);
}
