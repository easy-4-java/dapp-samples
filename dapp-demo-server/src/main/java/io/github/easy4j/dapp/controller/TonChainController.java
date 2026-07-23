package io.github.easy4j.dapp.controller;

import io.github.easy4j.api.ApiRestResponse;
import io.github.easy4j.api.XHeaders;
import io.github.easy4j.dapp.entity.ConfigChainDailySign;
import io.github.easy4j.dapp.param.ChainDailySignClaimReq;
import io.github.easy4j.dapp.param.TonProofCheckReq;
import io.github.easy4j.dapp.service.ChainDailySignService;
import io.github.easy4j.dapp.service.ConfigChainDailySignService;
import io.github.easy4j.dapp.service.TonChainService;
import io.github.easy4j.dapp.util.TonConnectUtil;
import io.github.easy4j.dapp.vo.ConfigChainDailySignInfoVO;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ton/v1")
@Slf4j
public class TonChainController {

    private final TonChainService tonChainService;
    private final ConfigChainDailySignService configChainDailySignService;
    private final ChainDailySignService chainDailySignService;

    @Autowired
    public TonChainController(TonChainService tonChainService,
                              ConfigChainDailySignService configChainDailySignService,
                              ChainDailySignService chainDailySignService) {
        this.tonChainService = tonChainService;
        this.configChainDailySignService = configChainDailySignService;
        this.chainDailySignService = chainDailySignService;
    }

    /**
     * 获取离线
     * @return
     */
    @GetMapping("/daily-sign-config")
    public ApiRestResponse<List<ConfigChainDailySignInfoVO>> getDailySignInfos() {
        List<ConfigChainDailySign> result = configChainDailySignService.getChainDailySignInfos();
        List<ConfigChainDailySignInfoVO> respList = Lists.newArrayList();
        for (ConfigChainDailySign dailySign : result) {
            respList.add(ConfigChainDailySignInfoVO.buildConfigDailySignInfoResp(dailySign));
        }
        return ApiRestResponse.success(respList);
    }

    @PostMapping("/daily-sign-claim")
    public ApiRestResponse<Map<String, String>> dailySignClaim(@RequestHeader(XHeaders.X_APP_ID) String appId,
                                                               @RequestBody @Validated ChainDailySignClaimReq req) {
        Map<String, String> result = chainDailySignService.dailySignClaim(appId, req);
        return ApiRestResponse.success(result);
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
            boolean checked = TonConnectUtil.checkProof(appId, req);
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
