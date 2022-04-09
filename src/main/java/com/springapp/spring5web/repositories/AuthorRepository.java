package com.springapp.spring5web.repositories;


import com.springapp.spring5web.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
