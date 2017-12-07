package examination.config;

import examination.interceptor.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer
        extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new CaptchaInterceptor()).addPathPatterns("/doLogin");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/","/defaultKaptcha","/doLogin");
        registry.addInterceptor(new StudentInterceptor()).addPathPatterns("/student/**");
        registry.addInterceptor(new TeacherInterceptor()).addPathPatterns("/teacher/**");
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**");
    }

}
