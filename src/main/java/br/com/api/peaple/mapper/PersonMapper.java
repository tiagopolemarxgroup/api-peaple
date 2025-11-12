package br.com.api.peaple.mapper;

import br.com.api.peaple.dtos.request.PersonRequestDto;
import br.com.api.peaple.dtos.response.PersonResponseDto;
import br.com.api.peaple.entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonMapper {

    public Person toPerson(PersonRequestDto dto){
        Person person = new Person();
         person.setName(dto.getName());
         person.setCpf(dto.getCpf());
         person.setAge(dto.getAge());
        return person;
    }

   public PersonResponseDto toPersonResponseDto(Person person){
        PersonResponseDto dto = new PersonResponseDto();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setCpf(person.getCpf());
        dto.setAge(person.getAge());
        return dto;
    }

    public List<PersonResponseDto> toListPersonResponseDto(List<Person> person) {
        return person.stream().map(this::toPersonResponseDto).toList();
    }

    public void update(Person person, PersonRequestDto dto){
        person.setName(dto.getName());
        person.setCpf(dto.getCpf());
        person.setAge(dto.getAge());
    }
}
