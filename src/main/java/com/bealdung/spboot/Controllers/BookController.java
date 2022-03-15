package com.bealdung.spboot.Controllers;

import com.bealdung.spboot.Exceptions.BookIdMismatchException;
import com.bealdung.spboot.Exceptions.BookNotFoundException;
import com.bealdung.spboot.Repository.BookRepo;
import com.bealdung.spboot.modals.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/books")
    public List<Book> getAllBooks()
        {
            return (List<Book>) bookRepo.findAll();

        }
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id)
    {
        bookRepo.findById(id).orElseThrow(BootstrapMethodError::new);
        return bookRepo.findById(id).get();
    }
    @PostMapping("/book")
    public  Book createBook(@RequestBody Book b)
    {
        return bookRepo.save(b);
    }
    @DeleteMapping("/book/{id}")
    public  void deleteBookById(@PathVariable int id)
    {
        bookRepo.findById(id).orElseThrow(BootstrapMethodError::new);
        bookRepo.deleteById(id);
    }
    @DeleteMapping("/books")
    public void deleteAllBooks()
    {
        bookRepo.deleteAll();

    }
    @PutMapping("/books/{id}")
    public Book getBookById(@PathVariable int id,@RequestBody Book b)
    {
       if(b.getId() != id)
       {
           throw new BookIdMismatchException();
       }
        bookRepo.findById(id).orElseThrow(BootstrapMethodError::new);

        Book bb= bookRepo.findById(id).get();
        bb.setAuthor(b.getAuthor());
        bb.setId(b.getId());
        bb.setName(b.getName());
        return bb;
    }





}
