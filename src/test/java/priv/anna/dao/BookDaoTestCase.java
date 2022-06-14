package priv.anna.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.anna.domain.Book;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired private BookDao bookDao;

    @Test
    void testGetById(){
       // System.out.println(bookDao.selectById(1));
//
//        Book book = new Book();
//        book.setType("sdfff");
//        book.setName("ffffff");
//        book.setDescription("ffffffffffffffffff");
//
//        int insert = bookDao.insert(book);
//        System.out.println(insert);

    }

    @Test
    void testGetAll(){
        bookDao.selectList(null);

    }

    /**
     * 分页
     */
    @Test
    void testGetPage(){
        IPage page = new Page(2,5);//当前页，每页显示条数
        bookDao.selectPage(page,null);
    }

    /**
     * 条件查询
     */
    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name","直播");  //条件： name中包含"直播"的数据
        bookDao.selectList(qw);
    }

    /**
     * 条件查询，方法二（推荐）
     */
    @Test
    void testGetBy2(){
        //String name = "直播";
        String name = null;

        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();

        /*
        like()方法中参数condition的值：如果为true 则Sql语句连接查询条件 ，如果为false，则不连数条件
        为了防止空指针，可以将name!=null传递给condition
         */
        lqw.like(Strings.isNotEmpty(name),Book::getName,name) ;  //条件
        bookDao.selectList(lqw);
    }

}
