package cn.zippler.xsserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.ManyToOne;

/**
 * Created by Zipple on 2018/5/14.
 * about words
 */
public class Comment implements Cloneable {
    private int id;
    private int userId;
    private int pic;
    private String name;
    private String content;
    private String time;

    @ManyToOne(optional = false)
    private Video video;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public Video getVideo() {
        return video;
    }

    @JsonBackReference
    public void setVideo(Video video) {
        this.video = video;
    }
}
