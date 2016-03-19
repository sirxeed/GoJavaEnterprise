public class ValidatorImplementation implements Validator<Number> {
    @Override
    public boolean isValid(Number result) {
        if (result.doubleValue() > 2 && result.doubleValue() < 50) {
            return true;
        }
        return false;
    }
}
