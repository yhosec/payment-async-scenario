package com.josep.asyncschenarioproducer.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import static io.r2dbc.pool.PoolingConnectionFactoryProvider.MAX_SIZE;
import static io.r2dbc.spi.ConnectionFactoryOptions.DATABASE;
import static io.r2dbc.spi.ConnectionFactoryOptions.DRIVER;
import static io.r2dbc.spi.ConnectionFactoryOptions.HOST;
import static io.r2dbc.spi.ConnectionFactoryOptions.PASSWORD;
import static io.r2dbc.spi.ConnectionFactoryOptions.PORT;
import static io.r2dbc.spi.ConnectionFactoryOptions.USER;

@Configuration
public class R2DBCConfig {
    private final Environment env;

    public R2DBCConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(
            ConnectionFactoryOptions.builder()
                .option(DRIVER, "postgresql")
                .option(HOST, env.getRequiredProperty("spring.db.host"))
                .option(PORT, Integer.parseInt(env.getRequiredProperty("spring.db.port")))
                .option(USER, env.getRequiredProperty("spring.db.user"))
                .option(PASSWORD, env.getRequiredProperty("spring.db.password"))
                .option(DATABASE, "postgres")
                .option(MAX_SIZE, 40)
                .build());
    }
}
