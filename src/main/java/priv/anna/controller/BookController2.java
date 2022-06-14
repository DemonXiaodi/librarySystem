package priv.anna.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.anna.domain.Book;
import priv.anna.service.BookService;
import priv.anna.controller.util.R;

import java.io.IOException;

/**
 * 增加了 响应数据统一格式 的功能 方便前端人员使用
 */
@RestController
@RequestMapping("/2books")
public class BookController2 {

    @Autowired
    private BookService bookService;

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {  //请求体传参数
        //if (true) throw new IOException();
        Boolean flag = bookService.save(book);
        R r = new R(flag,flag?"添加成功ヾ(≧ ▽ ≦)ゝ":"添加失败(T_T)"); //由于R中已经有构造方法
        return r;
    }

    @PutMapping
    public R update(@RequestBody Book book){  //请求体传参数
        R r = new R(bookService.update(book)); //由于R中已经有构造方法
        return r;
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){  //路径变量传参数 例如：http://localhost/books/2，参数是2
        R r = new R(bookService.delete(id)); //由于R中已经有构造方法
        return r;
    }


    @GetMapping
    public R getAll(){
        R r = new R(true,bookService.getAll());
        return r;
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){  //路径变量传参数
       R r = new R(true,bookService.getById(id));
       return  r;
    }

    //分页查询
//    @GetMapping("{current}/{pageSize}")
//    public R getPage(@PathVariable int current,@PathVariable int pageSize){
//        IPage<Book> page = bookService.getPage(current, pageSize);
//        //如果当前页码值大于总页码值，那么从新执行查询操作，使用最大页码值作为当前页码值
//        if (current > page.getPages()){
//            page = bookService.getPage((int) page.getPages(), pageSize);
//        }
//
//        R r = new R(true,page);
//       return r;
//    }

    /**
     * 分页查询  条件查询
     * @param current
     * @param pageSize
     * @return
     */
    @GetMapping("{current}/{pageSize}")
    public R getPage(@PathVariable int current,@PathVariable int pageSize,Book book){
        IPage<Book> page = bookService.getPage(current, pageSize,book);
        //如果当前页码值大于总页码值，那么从新执行查询操作，使用最大页码值作为当前页码值
        if (current > page.getPages()){
            page = bookService.getPage((int) page.getPages(), pageSize,book);
        }

        R r = new R(true,page);
        return r;
    }


}
