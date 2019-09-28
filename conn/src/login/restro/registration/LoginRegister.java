package login.restro.registration;

import java.io.IOException;

import javax.servlet.ServletException;
//import java.io.IOException;
//import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public LoginRegister() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			
	{
		try {
		CustomerDAO cd=new CustomerDAOimpl();
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		String submitType=request.getParameter("submit");
		Customer c=cd.getCustomer(userName, password);
		if(submitType.equals("login") && c!=null && c.getPassword()!=null) {
			request.setAttribute("message",c.getName());
			//JOptionPane.showMessageDialog(null, "Username and Password exist"); 
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else if(submitType.equals("register")) {
			c.setName(request.getParameter("name"));
			c.setPassword(password);
			c.setUsername(userName);
			cd.insertCustomer(c);
			request.setAttribute("successmessage","register done,login to continue !!! ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		
			
			
		}else {
			request.setAttribute("message","data not found,click on register !!! ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		}catch(NullPointerException | ServletException | IOException e) {
		System.out.println("success");}
		
	}

}
