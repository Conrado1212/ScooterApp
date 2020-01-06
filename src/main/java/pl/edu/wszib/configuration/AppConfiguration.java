package pl.edu.wszib.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.dao.IScooterDAO;
import pl.edu.wszib.dao.impl.ScooterDAOImpl;
import pl.edu.wszib.dao2.IUserDAO;
import pl.edu.wszib.dao2.impl.UserDAOImpl;
import pl.edu.wszib.services.IScooterServices;
import pl.edu.wszib.services.IUserService;
import pl.edu.wszib.services.impl.ScooterServiceImpl;
import pl.edu.wszib.services.impl.UserServiceImpl;

@Configuration
public class AppConfiguration {
    @Bean
    public SessionFactory hibernateSessionFactory(){
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }
    @Bean
    public IScooterDAO scooterDAO(SessionFactory hibernateSessionFactory){
        return  new ScooterDAOImpl(hibernateSessionFactory);
    }
    @Bean
    public IScooterServices scooterServices(IScooterDAO scooterDAO){
        return new ScooterServiceImpl(scooterDAO);
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

