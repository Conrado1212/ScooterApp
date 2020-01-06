package pl.edu.wszib.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.dao2.IUserDAO;
import pl.edu.wszib.dao2.impl.UserDAOImpl;
import pl.edu.wszib.services.IUserService;
import pl.edu.wszib.services.impl.UserServiceImpl;

@Configuration
public class AppConfiguration {
    @Bean
    public SessionFactory hibernateSessionFactory(){
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    @Bean
    public IUserDAO userDAO(SessionFactory hibernateSessionFactory){
        return new UserDAOImpl(hibernateSessionFactory);
    }
    @Bean
    public IUserService userService(IUserDAO userDAO) {
        return new UserServiceImpl(userDAO);
    }
    }

