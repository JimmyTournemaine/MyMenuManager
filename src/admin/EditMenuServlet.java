package admin;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditMenuServlet
 */
@WebServlet("/edit")
public class EditMenuServlet extends AbstractAdminServlet implements Servlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(!isAccessGranted(request, response)) {
            return;
        }
        response.getWriter().append("Served at: ").append(request.getContextPath());
        response.getWriter().append("Status   : ").append((new Integer(response.getStatus())).toString());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(!isAccessGranted(request, response)) {
            return;
        }
        doGet(request, response);
    }

}
