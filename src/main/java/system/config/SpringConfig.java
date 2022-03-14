package system.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Класс конфигурации, замена XML настройки
 */

@Configuration
@ComponentScan("system")
/*
replaces <mvc:annotation-driven> in XML
*/
@EnableWebMvc
public class SpringConfig  {
}
