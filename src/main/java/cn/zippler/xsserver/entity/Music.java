package cn.zippler.xsserver.entity;

import javax.persistence.Transient;

/**
 * Created by Zipple on 2018/5/6.
 * Music entity ,DTO
 */
public class Music {
     private int id;
     private String name;
     private String desc;
     private String url;
     @Transient
     private String poster;//default poster url

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

}
