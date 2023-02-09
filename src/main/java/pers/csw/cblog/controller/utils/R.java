package pers.csw.cblog.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author csw
 * @date 2022/3/5
 * @time 12:37
 */
@Data
@AllArgsConstructor
public class R {
    private Boolean flag;
    private Object data;
    private String msg;

    public R(Boolean flag) {
        this.flag = flag;
    }
    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R() {
    }
    public R(String msg) {
        this.msg = msg;
    }
    public R(Boolean flag,String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}
