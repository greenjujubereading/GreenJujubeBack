package com.bupt.qingzaoreading.service.serviceImpl;

import com.bupt.qingzaoreading.dao.VerifyCodeMapper;
import com.bupt.qingzaoreading.po.VerifyCode;
import com.bupt.qingzaoreading.service.VerifyCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("VerifyCodeServiceImpl")
public class VerifyCodeServiceImpl implements VerifyCodeService {


    @Autowired
    private VerifyCodeMapper verifyCodeMapper;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Override
    public void deleteVerifyCode(VerifyCode verifyCode) {
        logger.info("deleteVerifyCode方法执行，参数UserPhone="+verifyCode.getUserPhone());
        verifyCodeMapper.deleteByPrimaryKey(verifyCode.getUserPhone());
        logger.info("deleteVerifyCode方法执行结束");
    }


    @Override
    public void addVerifyCode(VerifyCode verifyCode) {
        logger.info("addVerifyCode，参数UserPhone="+verifyCode.getUserPhone());
        verifyCodeMapper.insert(verifyCode);
        logger.info("addVerifyCode方法执行结束");
    }

    @Override
    public VerifyCode getVerifyCodeByphone(String user_phone) {
        logger.info("getVerifyCodeByphone，参数UserPhone="+user_phone);
        VerifyCode vc=verifyCodeMapper.selectByPrimaryKey(user_phone);
        logger.info("getVerifyCodeByphone方法执行结束,结果：verifycode:"+vc.getVerifyCode());
        return vc;
    }
}
