package com.scut.blockchain.repository;

import com.scut.blockchain.model.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserDao extends Mapper<User> {

}
