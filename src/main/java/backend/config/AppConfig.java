package backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/**
 * <h3>Setup Annotations for Config Class</h3>
 * <p><b>Configuration</b>, <b>EnableWebMvc</b></p>
 * <p><b>EnableTransactionManagement</b>, <b>EnableSpringDataWebSupport</b></p>
 * <p><b>PropertySource</b> for Upload File, <b>ComponentScan</b> for Controller</p>
 * <p><b>EnableJpaRepositories</b> for Repositories</p>
 */
@Configuration
@EnableWebMvc
@ComponentScan("backend.controller")
@EnableWebSecurity
public class AppConfig implements WebMvcConfigurer {
    /**
     * <h3>01. Thymeleaf Resolver Configuration</h3>
     * <p>Step 1: Create Spring Resource <b>Template Resolver</b> Configuration</p>
     * <p>Step 2: Create Spring <b>Template Engine</b> Configuration</p>
     * <p>Step 3: Create Thymeleaf <b>View Resolver</b> Configuration</p>
     */
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addDialect(new SpringSecurityDialect());
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }
}
