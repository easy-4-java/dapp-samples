package io.github.easy4j.dapp.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public enum UserDailySignStatusEnum {
    NOT_TRADE,
    WAIT_CLAIM,
    CLAIMED,

    ;

}
