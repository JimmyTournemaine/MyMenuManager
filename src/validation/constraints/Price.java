package validation.constraints;

public class Price extends Decimal {

    public Price() {
        super(2);
    }

    @Override
    public boolean valid(Object value) {
        if (!super.valid(value)) return false;
        if(value == null) return true;
        return Float.parseFloat((String) value) >= 0;
    }

}
