package IncDao.vo;

import java.util.Date;

/**
 * Created by winfath on 16/1/1.
 */
public class User_message {
    String user_id;
    String user_name;
    String message_title;
    String message_value;
    Date message_date;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Date getMessage_date() {
        return message_date;
    }

    public void setMessage_date(Date message_date) {
        this.message_date = message_date;
    }

    public String getMessage_value() {
        return message_value;
    }

    public void setMessage_value(String message_value) {
        this.message_value = message_value;
    }

    public String getMessage_title() {
        return message_title;
    }

    public void setMessage_title(String message_title) {
        this.message_title = message_title;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
