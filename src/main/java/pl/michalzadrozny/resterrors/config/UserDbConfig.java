package pl.michalzadrozny.resterrors.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
        basePackages = "pl.michalzadrozny.resterrors.repository.user",
        entityManagerFactoryRef = "userEntityManager",
        transactionManagerRef = "userTransactionManager")
public class UserDbConfig extends DBConfig {

    protected UserDbConfig() {
        super(new String[]{"pl.michalzadrozny.resterrors.model.user"});
    }

    @Primary
    @Bean("userDataSource")
    @Override
    @ConfigurationProperties(prefix = "spring.datasource-user")
    protected DataSource dataSource() {
        return super.dataSource();
    }

    @Primary
    @Bean("userEntityManager")
    @Override
    protected LocalContainerEntityManagerFactoryBean entityManager() {
        return super.entityManager();
    }

    @Primary
    @Bean("userTransactionManager")
    @Override
    protected PlatformTransactionManager transactionManager() {
        return super.transactionManager();
    }
}