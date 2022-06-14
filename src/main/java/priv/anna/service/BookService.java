package priv.anna.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import priv.anna.domain.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    //分页
    IPage<Book> getPage(int currentPage,int pageSize);

    //分页，条件查询
    IPage<Book> getPage(int currentPage,int pageSize,Book book);
}
