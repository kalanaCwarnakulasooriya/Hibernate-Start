import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
//        Customer customer = new Customer(
//                1,
//                "Dirusha Eshral",
//                "dikka@example.com"
//        );
//
//        saveCustomer(customer);

//        Customer customer = getCustomerById(1);
//        System.out.println(customer);

//        deleteCustomer(1);

        updateCustomer(1, new Customer(
                1, "Dirusha Eshral",
                "dikka@example.com"
                )
        );
    }

    public static Customer getCustomerById(int id){
        Session session = FactoryConfiguration.getInstance().getSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    public static boolean deleteCustomer(int id){
        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            Transaction transaction = session.beginTransaction();

            Customer customer = session.get(Customer.class, id);
            session.delete(customer);

            transaction.commit();
            System.out.println("Data Deleted");
            return true;

        } catch (Exception e) {
            System.out.println("Faild to delete data");
            return false;
        }finally {
            session.close();
        }
    }

    public static boolean updateCustomer(int id, Customer newCustomer){
        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            Customer customer = session.get(Customer.class, id);
            Transaction transaction = session.beginTransaction();

            customer.setName(newCustomer.getName());
            customer.setEmail(newCustomer.getEmail());

            transaction.commit();
            System.out.println("Data Updated");
            return true;
        } catch (Exception e) {
            System.out.println("Faild to update data");
            return false;
        }finally {
            session.close();
        }
    }

    public static boolean saveCustomer(Customer customer) {
        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            Transaction transaction = session.beginTransaction();

            session.save(customer);

            transaction.commit();

            System.out.println("Data Saved");
            return true;
        } catch (Exception e) {
            System.out.println("Faild to save data");
            return false;
        } finally {
            session.close();
        }
    }
}
