package io.github.easy4j.dapp.service;

import io.github.easy4j.dapp.param.TonTransactionCheckReq;

public interface TonChainService {

    /**
     * 在服务器端检查 Transaction 是否有效
     * @param appId 客户端ID
     * @param req 请求参数
     * @return 是否验证通过
     */
    boolean checkTransaction(String appId, TonTransactionCheckReq req);

}
