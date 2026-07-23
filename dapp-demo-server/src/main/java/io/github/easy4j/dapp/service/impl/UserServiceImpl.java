package io.github.easy4j.dapp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.easy4j.dapp.entity.User;
import io.github.easy4j.dapp.mapper.UserMapper;
import io.github.easy4j.dapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
