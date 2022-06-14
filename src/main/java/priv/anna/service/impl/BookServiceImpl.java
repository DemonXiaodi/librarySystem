package priv.anna.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.anna.service.BookService;
import priv.anna.dao.BookDao;
import priv.anna.domain.Book;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        int insert = bookDao.insert(book);//返回值是：影响的行数
        return insert > 0;  //大于零时返回true

    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    //分页查询
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<Book>(currentPage,pageSize);
        return  bookDao.selectPage(page,null);  //null是查询条件
    }

    /**
     * 分页条件查询
     */
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {

        //封装查询条件
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());

        //创建 IPage 对象，传入当前页和每页显示条数
        IPage page = new Page(currentPage,pageSize);

        //page和 查询条件传入dao层
        bookDao.selectPage(page,lqw);
        return page;
    }
}
