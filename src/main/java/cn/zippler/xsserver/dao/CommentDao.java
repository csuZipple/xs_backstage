package cn.zippler.xsserver.dao;

import cn.zippler.xsserver.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment,Long> {
}
