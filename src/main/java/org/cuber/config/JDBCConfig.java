package org.cuber.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by cuber on 2016/1/29.
 */
@Configuration
@ImportResource("classpath:spring/spring-jdbc.xml")
public class JDBCConfig {
}
