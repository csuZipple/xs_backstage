package cn.zippler.xsserver.dao;

import cn.zippler.xsserver.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoDao extends JpaRepository<Video,Long> {
}
