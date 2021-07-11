package com.example.lab;

import cn.soundbus.spring.swagger.boot.autoconfigure.EnableSwagger2Doc;
import com.example.lab.interceptor.CasbinHandlerInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@EnableSwagger2Doc
@ComponentScan({"cn.soundbus","com.example.lab"})
public class GrpcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcClientApplication.class, args);
	}

}

@Configuration
class InterceptorConfig extends WebMvcConfigurationSupport {

	// 提前加载bean,解决CasbinHandlerInterceptor注入bean为空.
	@Bean
	public HandlerInterceptor getCasbinHandlerInterceptor(){
		return new CasbinHandlerInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getCasbinHandlerInterceptor())
				.excludePathPatterns("/getPolicy")// 放行uri
				.addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
