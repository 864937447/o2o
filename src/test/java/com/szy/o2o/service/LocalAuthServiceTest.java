package com.szy.o2o.service;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.szy.o2o.BaseTest;
import com.szy.o2o.dto.LocalAuthExecution;
import com.szy.o2o.entity.LocalAuth;
import com.szy.o2o.entity.PersonInfo;
import com.szy.o2o.enuma.WechatAuthStateEnum;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocalAuthServiceTest extends BaseTest {
	@Autowired
	private LocalAuthService localAuthService;

	@Test
	@Ignore
	public void testABindLocalAuth() {
		// 新增一条平台帐号
		LocalAuth localAuth = new LocalAuth();
		PersonInfo personInfo = new PersonInfo();
		String username = "testusername1";
		String password = "testpassword1";
		// 给平台帐号设置上用户信息
		// 给用户设置上用户Id,标明是某个用户创建的帐号
		personInfo.setUserId(1L);
		// 给平台帐号设置用户信息,标明是与哪个用户绑定
		localAuth.setPersonInfo(personInfo);
		// 设置帐号
		localAuth.setUsername(username);
		// 设置密码
		localAuth.setPassword(password);
		// 绑定帐号
		LocalAuthExecution lae = localAuthService.bindLocalAuth(localAuth);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), lae.getState());
		// 通过userId找到新增的localAuth
		localAuth = localAuthService.getLocalAuthByUserId(personInfo.getUserId());
		// 打印用户名字和帐号密码看看跟预期是否相符
		System.out.println("用户昵称：" + localAuth.getPersonInfo().getUserName());
		System.out.println("平台帐号密码：" + localAuth.getPassword());
	}

	@Test
	public void testBModifyLocalAuth() {
		// 设置帐号信息
		long userId = 1L;
		String username = "testusername1";
		String password = "testuserpassword";
		String newPassword = "123";
		// 修改该帐号对应的密码
		LocalAuthExecution lae = localAuthService.modifyLocalAuth(userId, username, password, newPassword);
		assertEquals(WechatAuthStateEnum.SUCCESS.getState(), lae.getState());
		// 通过帐号密码找到修改后的localAuth
		LocalAuth localAuth = localAuthService.getLocalAuthByUsernameAndPwd(username, newPassword);
		// 打印用户名字看看跟预期是否相符
		System.out.println(localAuth.getPersonInfo().getUserName());
	}
}
