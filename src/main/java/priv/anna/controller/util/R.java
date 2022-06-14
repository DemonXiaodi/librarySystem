package priv.anna.controller.util;

import lombok.Data;

//模型类，用于响应数据统一格式，方便前端人员使用
@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;


    public R(){

    }

    public R(Boolean flag){
        this.flag = flag;
    }

    public R(Boolean flag,Object date){
        this.flag = flag;
        this.data = date;
    }

    public R(String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}
