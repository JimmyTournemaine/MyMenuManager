package form;

import validation.constraints.ConstraintInterface;
import validation.constraints.NotBlank;
import validation.constraints.Price;

public class DishForm extends AbstractForm {

    private final static String name = "name";
    private final static String description = "description";
    private final static String price = "price";
    private final static String image = "image";

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
    
    public String getImage() {
        return image;
    }

    public DishForm() {
        ConstraintInterface[] cs = { new NotBlank() };
        ConstraintInterface[] fl = { new NotBlank(), new Price() };
        constraints.put(name, cs);
        constraints.put(description, cs);
        constraints.put(price, fl);
        constraints.put(image, new ConstraintInterface[0]);
    }
}
