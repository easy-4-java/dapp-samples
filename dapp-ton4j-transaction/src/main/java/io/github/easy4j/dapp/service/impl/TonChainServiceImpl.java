package io.github.easy4j.dapp.service.impl;

import io.github.easy4j.dapp.param.TonTransactionCheckReq;
import io.github.easy4j.dapp.service.TonChainService;
import io.github.easy4j.dapp.util.TonTransactionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TonChainServiceImpl implements TonChainService {

    @Override
    public boolean checkTransaction(String appId, TonTransactionCheckReq req) {
        try {
            return TonTransactionUtil.checkTransaction(req.getHashAddress(), req.getAddress());
        } catch (Exception e) {
            log.error("verifying error", e);
            return Boolean.FALSE;
        }
    }
}
