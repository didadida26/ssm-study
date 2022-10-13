package com.zjn.ssm.dao;

import com.zjn.ssm.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {

    @Insert("insert into tbl_book (type,name,description) values(#{type},#{name},#{description})")
    int save(Book book);  //返回值表示影响的行数

    @Update("update tbl_book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
    int update(Book book);

    @Delete("delete from tbl_book where id = #{id}")
    int delete(Integer id);

    @Select("select * from tbl_book where id = #{id}")
    Book getById(Integer id);

    @Select("select * from tbl_book")
    List<Book> getAll();
}