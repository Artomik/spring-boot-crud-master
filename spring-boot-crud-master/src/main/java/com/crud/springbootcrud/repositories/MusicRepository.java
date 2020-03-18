package com.crud.springbootcrud.repositories;

import java.util.List;

import com.crud.springbootcrud.entities.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends CrudRepository<Music, Long> {

    List<Music> findByName(String produtor);

}