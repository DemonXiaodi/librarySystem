package priv.anna.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import priv.anna.dao.BookDao;
import priv.anna.domain.Book;
import priv.anna.service.BookService2;

//mp简化业务层
public class BookServiceimpl2 extends ServiceImpl<BookDao, Book> implements BookService2 {

    @Override
    public boolean save1(Book book){
        return false;
    }
}
