package cn.zippler.xsserver.dao;

import cn.zippler.xsserver.entity.User;
import cn.zippler.xsserver.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoDao extends JpaRepository<Video,Long> {
    public List<Video>findVideosByDeployer(User user);
}
