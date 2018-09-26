package com.HellSpawn287.spring5_WebApp.repository;

import com.HellSpawn287.spring5_WebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
