package IncDao.vo;

/**
 * Created by winfath on 16/1/1.
 */
public class Users {
    String user_id;
    String user_name;
    String user_pwd;
    int level;

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public int getLevel() {
        return level;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
