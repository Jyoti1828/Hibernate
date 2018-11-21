import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.Employee;
import com.utility.HBUtil;


public class prog1 {

	public static void main(String[] args) {
		try(SessionFactory sf = HBUtil.getSessionFactory();
				Session ss = sf.openSession()){
			//1. Create criteria builder from session
			CriteriaBuilder cb = ss.getCriteriaBuilder();
			
			//2. create criteria query from criteria builder 
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			
			//3.create root from criteria query
			Root<Employee> root = cq.from(Employee.class);
			
			//4.optional if all records are required
			//cq.select(root);
			
			//5. create query from session
			List<Employee> list = ss.createQuery(cq).getResultList();
			
			list.forEach(s->{
				System.out.println("emp name = " +s.getName());
				System.out.println("Salary = " + s.getSalary());
				System.out.println("---------------------------------");
			});
		}catch(Exception e){
			
  
			e.printStackTrace();
		}

	}

}
