import java.text.MessageFormat;

public class Book {

    private final String name;
    private final int ageRecommendation;

    public Book(String name, int ageRecommendation) {
        this.name = name;
        this.ageRecommendation = ageRecommendation;
    }

    public String getName() {
        return name;
    }

    public int getAgeRecommendation() {
        return ageRecommendation;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0} (recommended for {1} year-olds or older)", name, ageRecommendation);
    }
}
