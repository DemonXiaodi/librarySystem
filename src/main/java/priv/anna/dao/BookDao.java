package priv.anna.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import priv.anna.domain.Book;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
