package hibernate;

import org.flywaydb.core.Flyway;
import planets.Planet;
import clients.Client;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import properties.PropertyReader;
import tickets.Ticket;


/*
Завдання №3 - створи CRUD сервіси для Client та Planet
Опиши сутності Client та Planet. Пропиши Hibernate мапінги для цих сутностей (таблиці в БД client та planet відповідно).
Напиши CRUD сервіси для обох сутностей - ClientCrudService та PlanetCrudService.
Напиши тестовий код, який додаватиме/видалятиме записи за допомогою цих сервісів. Переконайсь, що всі CRUD операції
працюють правильно.*/

public class HibernateUtil {   // яке призначення цього классу?  створити об'єкт SessionFactory

    private static final HibernateUtil INSTANCE;
    @Getter
    private SessionFactory sessionFactory;
    static  {
        INSTANCE = new HibernateUtil();
    }

    public HibernateUtil () {
         sessionFactory = new Configuration()
             .addAnnotatedClass(Client.class)  // кажемо шо в нас є пачка анотацій (це наш мепінг) і вони відносяться до класу Client
             .addAnnotatedClass(Planet.class)
             .addAnnotatedClass(Ticket.class)
             .buildSessionFactory();

        flywayMigration(PropertyReader.getConnectionUrlForH2());


    }

    public static HibernateUtil getINSTANCE() {
        return INSTANCE;
    }

    public void close() {
        sessionFactory.close();

    }

    private void flywayMigration(String h2ConnectionUrl) {
        Flyway flyway = Flyway
                .configure()
                .dataSource(h2ConnectionUrl, null, null)
                .load();
        flyway.migrate();
    }




}