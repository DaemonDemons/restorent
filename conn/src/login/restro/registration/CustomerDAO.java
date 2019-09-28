package login.restro.registration;

public interface CustomerDAO {
	public int insertCustomer(Customer c);
	public Customer getCustomer(String username,String pass);

}
