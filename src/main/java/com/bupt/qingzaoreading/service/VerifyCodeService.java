package com.bupt.qingzaoreading.service;

import com.bupt.qingzaoreading.po.VerifyCode;

public interface VerifyCodeService {

    /**
     *
     * @param verifyCode
     */
    void deleteVerifyCode(VerifyCode verifyCode);

    /**
     *
     * @param verifyCode
     */
    void addVerifyCode(VerifyCode verifyCode);

    /**
     *
     * @param user_phone
     * @return
     */
    VerifyCode getVerifyCodeByphone(String user_phone);
}
