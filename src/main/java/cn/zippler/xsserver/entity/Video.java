package cn.zippler.xsserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
public class Video {
    @Id
    @GeneratedValue
    private Long id;
    private String url;
    private String poster;
    private String description;
    @OneToMany(mappedBy = "video",cascade= CascadeType.ALL,fetch= FetchType.EAGER)
    private Set<Comment>comments;
    private long likes=0;//number of like.

    @ManyToOne(optional = false)
    private User deployer;

    @ManyToMany
    @JoinTable(joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "video_id") })//创建关系表
    private Set<User> favUsers;
    @Column(name="deployTime", updatable=false,columnDefinition = "timestamp default current_timestamp")
    private Timestamp deployTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public User getDeployer() {
        return deployer;
    }

    @JsonBackReference
    public void setDeployer(User deployer) {
        this.deployer = deployer;
    }

    public Set<User> getFavUsers() {
        return favUsers;
    }
    @JsonBackReference
    public void setFavUsers(Set<User> favUsers) {
        this.favUsers = favUsers;
    }

    public Timestamp getDeployTime() {
        return deployTime;
    }

    public void setDeployTime(Timestamp deployTime) {
        this.deployTime = deployTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
