package admin;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserInterface;


abstract public class AbstractAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AbstractAdminServlet() {
        super();
    }
	
	protected boolean isAccessGranted(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    UserInterface user = (UserInterface) request.getSession().getAttribute("user");
        if(user == null){
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
        return true;
	}

}
