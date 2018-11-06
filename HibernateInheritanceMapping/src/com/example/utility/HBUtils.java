package com.example.utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.example.mappedSuperClass.Book;
import com.example.mappedSuperClass.Mobile;
import com.example.mappedSuperClass.Product;

public class HBUtils {
	
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory(){
		if (sessionFactory == null) {

			Configuration cfg = new Configuration()
								.addAnnotatedClass(Product.class)
								.addAnnotatedClass(Book.class)
								.addAnnotatedClass(Mobile.class)
								.addAnnotatedClass(com.example.singleTableMapping.Product.class)
								.addAnnotatedClass(com.example.singleTableMapping.Book.class)
								.addAnnotatedClass(com.example.singleTableMapping.Mobile.class)
								.addAnnotatedClass(com.example.tablePerSubclass.Product.class)
								.addAnnotatedClass(com.example.tablePerSubclass.Book.class)
								.addAnnotatedClass(com.example.tablePerSubclass.Mobile.class);
								
								
			Properties properties = new Properties();
			properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			properties.put(Environment.URL, "jdbc:mysql://localhost/mydb");
			properties.put(Environment.USER, "root");
			properties.put(Environment.PASS, "root");
			properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");
			
			properties.put(Environment.HBM2DDL_AUTO, "update");
			
			properties.put(Environment.SHOW_SQL, "true");
			properties.put(Environment.FORMAT_SQL, "true");
			
			
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(properties).build();
			sessionFactory = cfg.buildSessionFactory(sr);
			
		}
		return sessionFactory;
	}
}
