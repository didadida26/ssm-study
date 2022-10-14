package com.zjn.ssm.controller;

import com.zjn.ssm.constants.Code;
import com.zjn.ssm.domain.Book;
import com.zjn.ssm.domain.Result;
import com.zjn.ssm.exception.BusinessException;
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
        if (flag) {
            return new Result(Code.SAVE_OK, null, "保存成功");
        } else {
            return new Result(Code.SAVE_ERR, null, "保存失败");
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
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        if (id == 2) {
            // qi ta yi chang cuo wu ce shi
            int i = 1 / 0;
        }
        if (book == null) {

            return new Result(Code.GET_ERR, new Book(), "cha xun jie guo wei kong");
        }
        if (id == 1) {
            System.out.println("业务错误");
            throw new BusinessException(Code.BUSINESS_ERR, "ye wu cuo wu");
        }

        return new Result(Code.GET_OK, book, "cha xun cheng gong");
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }
}