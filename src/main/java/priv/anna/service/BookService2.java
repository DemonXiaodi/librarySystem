package priv.anna.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import priv.anna.domain.Book;

//mp简化业务层
@Service
public interface BookService2 extends IService<Book> {

    //手工添加部分没有的功能
   // @Override//报错说明覆盖了，避免冲突要使其报错
    boolean save1(Book book);
}
