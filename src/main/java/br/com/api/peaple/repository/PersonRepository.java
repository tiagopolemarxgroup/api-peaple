package br.com.api.peaple.repository;

import br.com.api.peaple.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByCpf(String cpf);
    Person findByName(String name);
    Person findByAge(Integer age);
}
