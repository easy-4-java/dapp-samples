package io.github.easy4j.dapp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.easy4j.dapp.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
