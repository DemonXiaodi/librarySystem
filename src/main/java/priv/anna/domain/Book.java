package priv.anna.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@TableName("tbl_book")
@Data
public class Book {
   private Integer id;
   private String type;
   private String name;
   private String description;

}
