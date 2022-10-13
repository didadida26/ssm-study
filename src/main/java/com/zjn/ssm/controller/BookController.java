package com.zjn.ssm.controller;

import com.zjn.ssm.constants.Code;
import com.zjn.ssm.domain.Book;
import com.zjn.ssm.domain.Result;
import com.zjn.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        if (flag){
            return  new Result(Code.SAVE_OK,null, "保存成功");
        }else {
            return new Result(Code.SAVE_ERR,null, "保存失败");
        }
    }

    @PutMapping
    public boolean update(@RequestBody Book book) {
        return bookService.update(book);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }
}