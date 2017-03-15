package menu;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Dish;
import rmi.ClientRMI;

/**
 * Servlet implementation class ShowMenuServlet
 */
@WebServlet("/menu")
public class ShowMenuServlet extends HttpServlet {

    private static final long serialVersionUID = 8707003628125616452L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<Dish> dishes = ClientRMI.getServer().getDishes();
	    request.setAttribute("dishes", dishes);
		request.getServletContext().getRequestDispatcher("/pages/dish/index.jsp").forward(request, response);
	}

}
