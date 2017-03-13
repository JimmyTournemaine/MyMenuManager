package form;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import validation.Validator;
import validation.constraints.ConstraintInterface;

abstract public class AbstractForm {

    private Map<String, String> errors = new HashMap<String, String>();
    private Map<String, Object> values = new HashMap<String, Object>();
    protected Map<String, ConstraintInterface[]> constraints = new HashMap<String, ConstraintInterface[]>(); // constraints
    protected Validator validator = new Validator();

    public Map<String, String> getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return errors.size() > 0;
    }

    public boolean isSubmitted() {
        return values.isEmpty() == false;
    }

    /**
     * Get form values from the request
     * 
     * @param request
     * @return self
     */
    public AbstractForm handleRequest(HttpServletRequest request) {
        for (String field : constraints.keySet()) {
            values.put(field, request.getParameter(field));
        }
        return this;
    }

    /**
     * Check is form values are valid with respect to the constraints set.
     * 
     * @return If form values are valid
     */
    public boolean isValid() {
        if (values.isEmpty()) return false;

        for (String field : constraints.keySet()) {
            for (ConstraintInterface constraint : constraints.get(field)) {
                if (!constraint.valid(values.get(field))) {
                    errors.put(field, constraint.message());
                    break;
                }
            }
        }

        return errors.isEmpty();
    }

    public Object value(String field) {
        return values.get(field);
    }

    public void setValue(String field, Object value) {
        values.put(field, value);
    }
}
