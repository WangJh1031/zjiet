package IncDao.vo;

import java.util.Date;

/**
 * Created by winfath on 16/1/1.
 */
public class Inc_news {
    int news_id;
    String news_title;
    String news_value;
    Date news_date;

    public int getNews_id() {

        return news_id;
    }

    public Date getNews_date() {
        return news_date;
    }

    public String getNews_title() {

        return news_title;
    }

    public String getNews_value() {

        return news_value;
    }

    public void setNews_date(Date news_date) {

        this.news_date = news_date;
    }

    public void setNews_id(int news_id) {

        this.news_id = news_id;
    }

    public void setNews_title(String news_title) {

        this.news_title = news_title;
    }

    public void setNews_value(String news_value) {

        this.news_value = news_value;
    }
}
