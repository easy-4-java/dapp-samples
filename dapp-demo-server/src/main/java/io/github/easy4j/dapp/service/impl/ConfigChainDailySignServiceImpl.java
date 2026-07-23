package io.github.easy4j.dapp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.easy4j.dapp.entity.ConfigChainDailySign;
import io.github.easy4j.dapp.mapper.ConfigChainDailySignMapper;
import io.github.easy4j.dapp.service.ConfigChainDailySignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ConfigChainDailySignServiceImpl extends ServiceImpl<ConfigChainDailySignMapper, ConfigChainDailySign> implements ConfigChainDailySignService {


    @Override
    public List<ConfigChainDailySign> getChainDailySignInfos() {
        return getBaseMapper().selectList(new QueryWrapper<ConfigChainDailySign>());
    }

}
