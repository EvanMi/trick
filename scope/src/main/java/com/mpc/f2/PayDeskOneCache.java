package com.mpc.f2;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PayDeskOneCache {
    private String merchantId;
    private String mchOrderNo;
    private String orderNo;
    private String currency;
    private BigDecimal amount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireTime;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date completeTime;
    private String payCode;
    private String payProCode;
    private String qrCodeType;
    private String pushNumber;
    private String orderStatus;
    private Long expireSeconds;
}
