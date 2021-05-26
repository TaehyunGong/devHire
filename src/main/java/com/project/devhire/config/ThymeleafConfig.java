package com.project.devhire.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeleafConfig {

	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	public SpringResourceTemplateResolver templateResolver(){
		// SpringResourceTemplateResolver automatically integrates with Spring's own
		// resource resolution infrastructure, which is highly recommended.
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//		templateResolver.setApplicationContext(this.applicationContext);
		templateResolver.setPrefix("classpath:templates/");
		templateResolver.setSuffix(".html");
		// HTML is the default value, added here for the sake of clarity.
		templateResolver.setTemplateMode(TemplateMode.HTML); // HTML5 값은 비권장 됨
		// Template cache is true by default. Set to false if you want
		// templates to be automatically updated when modified.
		templateResolver.setCacheable(false); // 캐시 사용 안함(사용하면 html 수정시 서버 재기동 필요)
		return templateResolver;
	}
	
    @Bean
    public LayoutDialect layoutDialect() { // layoutDialect 사용
        return new LayoutDialect();
    }

	@Bean
	public SpringTemplateEngine templateEngine(){
		// SpringTemplateEngine automatically applies SpringStandardDialect and
		// enables Spring's own MessageSource message resolution mechanisms.
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		// Enabling the SpringEL compiler with Spring 4.2.4 or newer can
		// speed up execution in most scenarios, but might be incompatible
		// with specific cases when expressions in one template are reused
		// across different data types, so this flag is "false" by default
		// for safer backwards compatibility.
		templateEngine.setEnableSpringELCompiler(true); // Spring EL 사용
		templateEngine.addDialect(new LayoutDialect()); // layout 설정
		return templateEngine;
	}

	@Bean 
	public ThymeleafViewResolver viewResolver(){ 
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver(); 
		viewResolver.setTemplateEngine(templateEngine()); 
		viewResolver.setCharacterEncoding("UTF-8"); // 한글 깨짐 방지
		viewResolver.setOrder(1);
		viewResolver.setViewNames(new String[] {".html", ".xhtml"});
		return viewResolver; 
	}
}
