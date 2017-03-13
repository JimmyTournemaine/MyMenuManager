package admin;

import java.io.IOException;
import java.sql.Blob;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import form.DishForm;
import model.DishInterface;

/**
 * Servlet implementation class CreateDish
 */
@WebServlet("/dish/create")
public class CreateDishServlet extends AbstractAdminServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    if(!this.isAccessGranted(request, response))
	        return;
	    
        if(request.getAttribute("form") == null) {
            DishForm form = new DishForm();
            request.setAttribute("form", form);
        }
        this.getServletContext().getRequestDispatcher("/pages/dish/form.jsp").forward(request, response);
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!this.isAccessGranted(request, response))
            return;
        
        DishForm form = new DishForm();
        request.setAttribute("form", form);
        form.handleRequest(request);
        
        if(form.isValid()) {
            // TODO save the dish
            DishInterface dish = new DishInterface(){
                public void setName(String name) {}
                public String getName() { return (String) form.value(form.getName()); }
                public void setDescription(String name) {}
                public String getDescription() {return (String) form.value(form.getDescription());}
                public void setImage(Blob name){}
                public Blob getImage(){ return null; }
                public void setPrice(Float price){}
                public float getPrice(){return (float) form.value(form.getPrice());}
            };
            request.setAttribute("dish", dish);
        }
        doGet(request, response);
    }

}
