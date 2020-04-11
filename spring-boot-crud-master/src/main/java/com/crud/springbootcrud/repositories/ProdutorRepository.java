package com.crud.springbootcrud.repositories;

import java.util.List;

import com.crud.springbootcrud.entities.Produtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutorRepository extends CrudRepository<Produtor, Long> {

    List<Produtor> findByNome(String nome);

}