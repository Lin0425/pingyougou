package cn.itcast.core.entity;

import java.io.Serializable;

/**
 * 对象：封装用户操作的结果信息
 */
public class Result  implements Serializable{
    private boolean flay;
    private String message;

    public Result() {
    }

    public Result(boolean flay, String message) {
        this.flay = flay;
        this.message = message;
    }

    public boolean isFlay() {
        return flay;
    }

    public void setFlay(boolean flay) {
        this.flay = flay;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
