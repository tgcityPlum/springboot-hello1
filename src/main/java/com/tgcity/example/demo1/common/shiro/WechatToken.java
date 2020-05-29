package com.tgcity.example.demo1.common.shiro;

import lombok.Data;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author: Rainbow
 * @Date: 2019/8/6 16:24
 */
@Data
public class WechatToken extends UsernamePasswordToken {

	private String openId;

	@Override
	public Object getPrincipal() {
		return getOpenId();
	}

	@Override
	public Object getCredentials() {
		return "ok";
	}
	public WechatToken(String openId){
		this.openId=openId;
	}


}
