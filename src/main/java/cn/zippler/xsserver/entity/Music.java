package cn.zippler.xsserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Music {
    @Id
    @GeneratedValue
    private Long id;
    private String url;
    private String musicname;
    private String description;
    @Column(name="deployTime", updatable=false,columnDefinition = "timestamp default current_timestamp")
    private Timestamp time;

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

    public String getName() {
        return musicname;
    }

    public void setName(String name) {
        this.musicname = name;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Music() {
    }
}
