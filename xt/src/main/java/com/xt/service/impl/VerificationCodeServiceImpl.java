package com.xt.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.dao.generation.VerificationCodeMapper;
import com.xt.entity.generation.VerificationCode;
import com.xt.entity.generation.VerificationCodeExample;
import com.xt.service.VerificationCodeService;
import com.xt.util.PublicUtil;
import com.xt.util.SmsUtil;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

	@Autowired
	VerificationCodeMapper verificationCodeMapper;

	@Override
	public boolean sendVerificationCode(String phoneNo) {
		String code = PublicUtil.initId();
		code = code.substring(code.length() - 6);
		if (SmsUtil.sendVerificationCode(phoneNo, code)) {
			VerificationCode record = new VerificationCode();
			record.setPhoneNo(phoneNo);
			record.setSendTime(new Date());
			record.setSmsId(PublicUtil.initId());
			record.setVerificationCode(code);
			record.setVerificationStatus(Boolean.TRUE);
			verificationCodeMapper.insert(record);
			return true;
		}
		return false;
	}

	@Override
	public String getLastEffectiveCode(String phoneNo) {
		VerificationCodeExample example = new VerificationCodeExample();
		example.createCriteria().andPhoneNoEqualTo(phoneNo).andVerificationStatusEqualTo(Boolean.TRUE);
		example.setOrderByClause("order by send_time desc limit 0,1");
		List<VerificationCode> vcodes = verificationCodeMapper.selectByExample(example);
		if (vcodes != null && !vcodes.isEmpty()) {
			VerificationCode vcode = vcodes.get(0);
			vcode.setVerificationStatus(Boolean.FALSE);
			vcode.setModifyTime(new Date());
			verificationCodeMapper.updateByPrimaryKey(vcode);
			return vcode.getVerificationCode();
		}
		return null;
	}
}
