package com.utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.example.Department;
import com.example.Employee;

public class HBUtil {

	public static SessionFactory getSessionFactory(){
		Configuration configuration = new Configuration()
						.addAnnotatedClass(Employee.class)
						.addAnnotatedClass(Department.class);
		Properties properties = new Properties();
		properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost/mydb");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "root");
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.SHOW_SQL, "true");
		properties.put(Environment.FORMAT_SQL, "true");
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(properties).build();
		return configuration.buildSessionFactory(sr);
	}
}
