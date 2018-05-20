package cn.zippler.xsserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    private String content;
    @ManyToOne(optional = false)
    private User user;
    @ManyToOne(optional = false)
    private Video video;
    @Column(name="deployTime", updatable=false,columnDefinition = "timestamp default current_timestamp")
    private Timestamp time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }
    @JsonBackReference
    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }
    @JsonBackReference
    public void setVideo(Video video) {
        this.video = video;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
