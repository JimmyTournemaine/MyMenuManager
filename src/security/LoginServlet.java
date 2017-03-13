package security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import form.LoginForm;
import model.UserInterface;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if(request.getSession().getAttribute("user") != null) {
	        redirectToHome(response);
	        return;
	    }
	        
	    if(request.getAttribute("form") == null) {
	        LoginForm loginForm = new LoginForm();
	        request.setAttribute("form", loginForm);
	    }
		this.getServletContext().getRequestDispatcher("/pages/security/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    LoginForm loginForm = new LoginForm();
        request.setAttribute("form", loginForm);
	    loginForm.handleRequest(request);
	    
	    if(loginForm.isValid()) {
	        /* Check database */
	        // TODO authenticate user
	        if(loginForm.value(loginForm.getUsername()).equals("admin") && loginForm.value(loginForm.getPassword()).equals("admin"))
	        {
    	        // UserInterface user = ...
    	        UserInterface user = new UserInterface() {
                    public String getUsername() { return "admin";}
                    public void setUsername(String username) {}
                    public String getPassword() {return "admin";}
                    public void setPassword(String password) {}
    	        };
    	        request.getSession().setAttribute("user", user);
    	        redirectToHome(response);
    	        return;
	        }
	        /* Invalid user */
	        request.setAttribute("formError", "Bad credentials.");
	    }
		doGet(request, response);
	}
	
	private void redirectToHome(HttpServletResponse response) throws IOException {
	    response.sendRedirect(this.getServletContext().getContextPath());
	}

}
