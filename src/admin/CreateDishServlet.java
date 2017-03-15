package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Dish;
import form.DishForm;
import rmi.ClientRMI;

/**
 * Servlet implementation class CreateDish
 */
@WebServlet("/admin/dish/create")
public class CreateDishServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getAttribute("form") == null) {
            DishForm form = new DishForm(new Dish());
            request.setAttribute("form", form);
        }
        this.getServletContext().getRequestDispatcher("/pages/dish/new.jsp").forward(request,
                response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DishForm form = new DishForm(new Dish());
        request.setAttribute("form", form);
        form.handleRequest(request);

        if (form.isValid()) {
            Dish dish = form.getData();
            System.out.println(dish.getName());
            if(ClientRMI.getServer().createDish(dish)) {
                response.sendRedirect("/admin/dish/index");
                return;
            }
            request.setAttribute("formError", "Une erreur est survenue.");
        }
        doGet(request, response);
    }

}
