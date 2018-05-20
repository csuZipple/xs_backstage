package cn.zippler.xsserver.dao;

import cn.zippler.xsserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}
