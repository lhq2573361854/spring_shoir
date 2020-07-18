package com.tianling.shiro;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroApplicationTests {

    @Test
	void contextLoads() {
		SimpleByteSource user = new SimpleByteSource("user");
		//ByteSource user1 = ByteSource.Util.bytes("user");

		SimpleHash md5 = new SimpleHash("SHA-1", "123456", user, 1024);
//		System.out.println("md5 e4216961e03f91a7632f9fee1444d3bb= " + md5);
		System.out.println("md5 = " + md5);

	}

}
