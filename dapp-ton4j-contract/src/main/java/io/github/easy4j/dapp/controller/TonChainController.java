package io.github.easy4j.dapp.controller;

import io.github.easy4j.api.ApiRestResponse;
import io.github.easy4j.api.XHeaders;
import io.github.easy4j.dapp.param.TonProofCheckReq;
import io.github.easy4j.dapp.service.TonChainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ton/v1")
@Slf4j
public class TonChainController {

    private final TonChainService tonChainService;


    @Autowired
    public TonChainController(TonChainService tonChainService) {
        this.tonChainService = tonChainService;
    }

    /**
     * 在服务器端检查 ton_proof
     * <a href="https://docs.ton.org/develop/dapps/ton-connect/sign#checking-ton_proof-on-server-side">在服务器端检查 ton_proof</a>
     * @param appId 客户端ID
     * @param req 请求参数
     * @return
     */
    @GetMapping("/check_ton_proof")
    public ApiRestResponse<Map> checkTonProof(@RequestHeader(XHeaders.X_APP_ID) String appId,
                                              @RequestBody @Validated TonProofCheckReq req) {
        try {
            boolean checked = tonChainService.checkProof(appId, req);
            if(checked){
                return ApiRestResponse.success(Map.of("checked", true));
            }
            return ApiRestResponse.success(Map.of("checked", false));
        } catch (Exception e) {
            log.error("verifying error", e);
            return ApiRestResponse.fail("verifying error");
        }
    }



}
