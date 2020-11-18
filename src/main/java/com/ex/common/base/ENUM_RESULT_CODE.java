package com.ex.common.base;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum ENUM_RESULT_CODE {

    SUCCESS(200,"调用成功"),
    FAILDD(500,"调用异常");

    private int code;
    private String msg;
}
