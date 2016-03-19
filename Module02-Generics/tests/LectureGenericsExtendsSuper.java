import org.apache.commons.lang3.*;

public class LectureGenericsExtendsSuper {

    public interface Validator<T> {
        boolean isValid(T value);
    }

    public static class PersonValidator implements Validator<Person> {

        @Override
        public boolean isValid(Person person) {
            return StringUtils.isNotBlank(person.name) && StringUtils.isNotBlank(person.surname);
        }

    }

    public static class Person {
        public String name;
        public String surname;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }
    }
}
