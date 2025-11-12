package br.com.api.peaple.service;

import br.com.api.peaple.dtos.request.PersonRequestDto;
import br.com.api.peaple.dtos.response.PersonResponseDto;
import br.com.api.peaple.entity.Person;
import br.com.api.peaple.mapper.PersonMapper;
import br.com.api.peaple.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;


    @Override
    public PersonResponseDto save(PersonRequestDto dto) {
        Person person = personMapper.toPerson(dto);
        personRepository.save(person);
        return personMapper.toPersonResponseDto(person);
    }

    @Override
    public List<PersonResponseDto> findAll() {
       // personRepository.findAll().stream().map(x -> personMapper.toPersonResponseDto(x)).toList();
        return  personRepository.findAll().stream().map(personMapper::toPersonResponseDto).toList();

    }

    public List<PersonResponseDto> findAllWithMapper(){
        return personMapper.toListPersonResponseDto(personRepository.findAll());
    }

    @Override
    public PersonResponseDto findById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        return personMapper.toPersonResponseDto(person);
    }

    @Override
    public PersonResponseDto update(Long id, PersonRequestDto dto) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        personMapper.update(person, dto);
        return personMapper.toPersonResponseDto(personRepository.save(person));
    }

    @Override
    public String delete(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
        personRepository.deleteById(person.getId());
        return "Pessoa deletada com id: " + id + " deletada com sucesso";

    }
}
