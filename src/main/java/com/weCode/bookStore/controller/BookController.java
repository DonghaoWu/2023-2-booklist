package com.weCode.bookStore.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.http.ResponseEntity;

import com.weCode.bookStore.dto.BookDto;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
  @GetMapping
  public ResponseEntity<List<BookDto>> getBooks() {
    BookDto book = BookDto.builder()
                  .title("My First book title!!")
                  .build();

    List<BookDto> books = new ArrayList<>();
    books.add(book);
    return ResponseEntity.ok(books);
  }
}