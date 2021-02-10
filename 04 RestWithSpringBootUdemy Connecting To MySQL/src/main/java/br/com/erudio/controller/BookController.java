package br.com.erudio.controller;

import br.com.erudio.data.vo.BookVO;
import br.com.erudio.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("api/book/v1")
public class BookController {

    @Autowired
    private BookServices service;

    @GetMapping
    public List<BookVO> findAll() {
        List<BookVO> books = service.findAll();

        books.stream().forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
        return books;
    }

    @GetMapping("/{id}")
    public BookVO findById(@PathVariable("id") Long id) {
        BookVO bookVO = service.findById(id);
        bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return bookVO;
    }

    @PostMapping
    public BookVO create(@RequestBody BookVO book) {
        BookVO bookVO = service.create(book);
        bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
        return service.create(book);
    }

    @PutMapping
    public BookVO update(@RequestBody BookVO book) {
        BookVO bookVO = service.update(book);
        bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
        return bookVO;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}