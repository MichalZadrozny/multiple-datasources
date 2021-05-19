package pl.michalzadrozny.resterrors.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(
        basePackages = "pl.michalzadrozny.resterrors.dao.book",
        entityManagerFactoryRef = "bookEntityManager",
        transactionManagerRef = "bookTransactionManager")
public class BookDbConfig extends DBConfig {

    protected BookDbConfig() {
        super(new String[]{"pl.michalzadrozny.resterrors.model.book"});
    }

    @Bean("bookDataSource")
    @Override
    @ConfigurationProperties(prefix = "spring.datasource-book")
    protected DataSource dataSource() {
        return super.dataSource();
    }

    @Bean("bookEntityManager")
    @Override
    protected LocalContainerEntityManagerFactoryBean entityManager() {
        return super.entityManager();
    }

    @Bean("bookTransactionManager")
    @Override
    protected PlatformTransactionManager transactionManager() {
        return super.transactionManager();
    }

    @Override
    protected Map<String, Object> getProperties(Environment env) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("datasource-book.hibernate.hbm2ddl.auto"));
        return properties;
    }
}
