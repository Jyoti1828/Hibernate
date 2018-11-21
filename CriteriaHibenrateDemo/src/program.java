import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.Department;
import com.example.Employee;
import com.utility.HBUtil;


public class program {

	public static void main(String[] args) {
		try(SessionFactory sf = HBUtil.getSessionFactory();
				Session ss = sf.openSession()){
			Department dept = new Department(04, "Finance", "Delhi");
			Employee emp = new Employee(106, "Ravi", 95000, dept);
			ss.save(emp);
			ss.beginTransaction();
			ss.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
