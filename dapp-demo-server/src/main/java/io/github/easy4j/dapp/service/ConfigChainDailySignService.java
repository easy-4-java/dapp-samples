
package io.github.easy4j.dapp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.github.easy4j.dapp.entity.ConfigChainDailySign;

import java.util.List;

public interface ConfigChainDailySignService extends IService<ConfigChainDailySign> {

    List<ConfigChainDailySign> getChainDailySignInfos();

}
