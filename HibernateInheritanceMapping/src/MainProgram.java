import org.hibernate.Session;
import org.hibernate.SessionFactory;






import com.example.tablePerSubclass.Book;
import com.example.tablePerSubclass.Mobile;
import com.example.tablePerSubclass.Product;
//import com.example.singleTableMapping.Book;
//import com.example.singleTableMapping.Mobile;
//import com.example.mappedSuperClass.Book;
//import com.example.mappedSuperClass.Mobile;
import com.example.utility.HBUtils;


public class MainProgram {
	
	public static void main(String[] args) {
		SessionFactory sf = HBUtils.getSessionFactory();
		Session ss = sf.openSession();
		Book book = new Book(101, "Let Us C", 566, "pubtest", "authtest");
		Mobile mobile = new Mobile(201, "Samsung", 53000, "Galaxy S+", "Grey");
		Product product = new Product(301, "Clothes", 500);
		ss.beginTransaction();
		ss.merge(book);
		ss.merge(mobile);
		
		//in case of tablepersubclass
		ss.merge(product);
		ss.getTransaction().commit();
		
	}

}
