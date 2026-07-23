
package io.github.easy4j.dapp.service;

import io.github.easy4j.dapp.param.ChainDailySignClaimReq;

import java.util.Map;

public interface ChainDailySignService {

    /**
     * 用户每日链上签到
     * @param req
     * @return
     */
    Map<String, String> dailySignClaim(String appId, ChainDailySignClaimReq req);

}
