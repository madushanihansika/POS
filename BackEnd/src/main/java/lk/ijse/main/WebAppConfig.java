package lk.ijse.main;

import lk.ijse.repository.CustomerRepository;
import lk.ijse.repository.ItemRepository;
import lk.ijse.repository.OrderDetailRepository;
import lk.ijse.repository.OrderRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("lk.ijse")
@EnableWebMvc
@EnableJpaRepositories(basePackageClasses = {CustomerRepository.class, ItemRepository.class, OrderRepository.class, OrderDetailRepository.class})
@EnableTransactionManagement
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
