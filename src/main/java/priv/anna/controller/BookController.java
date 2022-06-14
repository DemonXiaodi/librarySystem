package priv.anna.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.web.bind.annotation.*;
import priv.anna.domain.Book;
import priv.anna.service.BookService;

import java.security.Provider;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAll(){

        return bookService.getAll();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){  //请求体传参数
        return bookService.save(book) ;
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){  //请求体传参数
        return bookService.update(book) ;
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id){  //路径变量传参数 例如：http://localhost/books/2，参数是2
       return bookService.delete(id);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){  //路径变量传参数
        return bookService.getById(id);
    }

    @GetMapping("{current}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int current,@PathVariable int pageSize){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+current+pageSize);
       return bookService.getPage(current,pageSize);
    }


}
