package com.zjn.ssm.service.impl;

import com.zjn.ssm.dao.BookDao;
import com.zjn.ssm.domain.Book;
import com.zjn.ssm.service.BookService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public boolean save(@NotNull Book book) {
        if (book.getType() == null || book.getDescription() == null || book.getName() == null){
            return false;
        }
        bookDao.save(book);
        return true;
    }

    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }
}