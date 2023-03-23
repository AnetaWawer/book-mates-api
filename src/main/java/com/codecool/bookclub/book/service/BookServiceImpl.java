package com.codecool.bookclub.book.service;
import com.codecool.bookclub.book.model.Book;
import com.codecool.bookclub.book.repository.BookRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findBookById(id);
    }

    /*TODO: add parameter page */
    @Override
    public List<Book> getAllBooks() {
        Pageable pageable = PageRequest.of(0, 20, Sort.by("title"));
        List<Book> books = bookRepository.findAll(pageable).getContent();
        return books;
    }



    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> findFourBooks() {
        List<Book> books = bookRepository.findAll();
        books = books.subList(0, 4);

        return books;
    }

}