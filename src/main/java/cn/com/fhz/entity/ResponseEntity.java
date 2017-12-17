package cn.com.fhz.entity;

/**
 * Created by woni on 17/12/17.
 */

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 用户返回用户操作结果
 */
public class ResponseEntity {
    private String msg ="错误";
    private Boolean status = false;
    private Date date = new Date();

    public ResponseEntity() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
