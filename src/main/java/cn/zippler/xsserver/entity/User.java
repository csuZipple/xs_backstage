package cn.zippler.xsserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String password;
    private String avatar = "avatar.jpg";

    @OneToMany(mappedBy = "deployer",cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Video> deploys;//@JsonBackReference

    @ManyToMany(mappedBy = "favUsers",cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Video> favideos;

    private int sex; //0 for male
    private Timestamp birthday;
    private String school;
    @Column(name="registerTime", updatable=false,columnDefinition = "timestamp default current_timestamp")
    private Timestamp registerTime;

    @Transient
    private Set<Integer> fansId;//the fans  多对多？？？？

    @OneToMany(mappedBy = "user",cascade= CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Comment> comment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Set<Video> getDeploys() {
        return deploys;
    }

    @JsonBackReference
    public void setDeploys(Set<Video> deploys) {
        this.deploys = deploys;
    }

    public Set<Video> getFavideos() {
        return favideos;
    }

    public void setFavideos(Set<Video> favideos) {
        this.favideos = favideos;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }


    public Set<Comment> getComment() {
        return comment;
    }

    public void setComment(Set<Comment> comment) {
        this.comment = comment;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public Set<Integer> getFansId() {
        return fansId;
    }

    public void setFansId(Set<Integer> fansId) {
        this.fansId = fansId;
    }

    public User() {
    }
}
