package cn.zippler.xsserver.dao;

import cn.zippler.xsserver.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicDao extends JpaRepository<Music,Long> {
}
