package com.HellSpawn287.spring5_WebApp.repository;

import com.HellSpawn287.spring5_WebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
