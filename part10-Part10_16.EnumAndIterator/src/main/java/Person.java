import java.text.MessageFormat;

public class Person {

    private final String name;
    private final Education education;

    public Person(String name, Education education) {
        this.name = name;
        this.education = education;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}, {1}", name, education);
    }
}
