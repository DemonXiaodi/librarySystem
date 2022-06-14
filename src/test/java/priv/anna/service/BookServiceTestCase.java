package priv.anna.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.anna.domain.Book;
import priv.anna.service.impl.BookServiceImpl;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookService bookService;

    @Test
    void test1(){
        Book book = new Book();
        book.setName("安徒生童话");
        book.setType("童话");
        book.setDescription("安徒生童话世界");
        bookService.save(book);
    }

    @Test
    void test2(){
        Book book = new Book();
        book.setId(15);
        book.setName("安徒生童话sss");
        book.setType("童话");
        book.setDescription("安徒生童话世界");
        bookService.update(book);
    }

    @Test
    void test3(){
        Book book = new Book();
        book.setName("异常生物见闻录");
        book.setType("科幻");
        book.setDescription("异常异常生物科幻搞笑");
        bookService.save(book);
    }

    @Test
    void test4(){
        IPage<Book> page = bookService.getPage(1, 3);

    }

    @Test
    void test5(){
        Book book = new Book();
        book.setName("三体");
       /* book.setType("科幻");
        book.setDescription("异常异常生物科幻搞笑");
        */
        IPage<Book> page = bookService.getPage(1, 10, book);
        System.out.println(page);

    }

}
