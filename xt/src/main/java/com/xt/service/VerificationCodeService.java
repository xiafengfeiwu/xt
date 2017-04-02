package com.xt.service;

public interface VerificationCodeService {
	
	boolean sendVerificationCode(String phoneNo);
	
	String getLastEffectiveCode(String phoneNo);
}
