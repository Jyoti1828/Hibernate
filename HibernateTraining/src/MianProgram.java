

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.Volunteer;

public class MianProgram {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure("myconfig.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Volunteer volunteer = new Volunteer(101, "test", "Noida");
		Transaction tx = ss.beginTransaction();
		ss.save(volunteer);
		tx.commit();
		ss.close();
		sf.close();
		

	}

}
