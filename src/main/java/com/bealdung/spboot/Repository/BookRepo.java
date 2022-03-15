package com.bealdung.spboot.Repository;

import com.bealdung.spboot.modals.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo  extends CrudRepository<Book,Integer> {
}
