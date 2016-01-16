package IncDao.vo;

/**
 * Created by winfath on 16/1/1.
 */
public class Items {
    int id;
    String item_id;
    String item_name;
    String item_info;
    String iclass;
    String isrc;

    public String getItem_id() {
        return item_id;
    }

    public String getItem_info() {
        return item_info;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public void setItem_info(String item_info) {
        this.item_info = item_info;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getIclass() {
        return iclass;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    public void setIclass(String iclass) {
        this.iclass = iclass;
    }

    public String getIsrc() {
        return isrc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
