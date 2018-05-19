package cn.zippler.xsserver.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;

/**
 * Created by Zipple on 2018/5/5.
 * The video will return from the cloud
 */
public class Video implements Serializable {
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "costume_user_fk")
    private User user;
    private String name;
    private String url;
    private String desc;
    @Column(name="registerTime", updatable=false,columnDefinition = "timestamp default current_timestamp")
    private Timestamp deployed;
    private int favorite;
    //服务器需要在后台生成对应的poster返回给android端
    private String poster;
    @OneToMany(mappedBy = "video")
    private Set<Comment> commentSet;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDeployed() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return deployed==null?"":sdf.format(deployed);
    }

    public void setDeployed(Timestamp deployed) {
        this.deployed = deployed;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }


    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }
}
