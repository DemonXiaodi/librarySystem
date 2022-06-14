package priv.anna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SSMPApplication {

	public static void main(String[] args) {

		SpringApplication.run(SSMPApplication.class,args);

		//可以这样定义临时属性
//		String[] arg2 = new String[1];
//		arg2[0] = "--server.port=8082";
//		SpringApplication.run(SSMPApplication.class, arg2);

		//可以在启动boot程序时断开读取外部临时配置对应的入口，也就是去掉args
//		SpringApplication.run(SSMPApplication.class);

	}

}
