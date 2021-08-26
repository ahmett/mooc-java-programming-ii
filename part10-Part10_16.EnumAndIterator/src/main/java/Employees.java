import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {

    private List<Person> personList;

    public Employees() {
        this.personList = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        personList.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        peopleToAdd.iterator().forEachRemaining(this::add);
    }

    public void print() {
        Iterator<Person> iterator = personList.iterator();

        while (iterator.hasNext()) {
            Person nextPerson = iterator.next();
            System.out.println(nextPerson);
        }
    }

    public void print(Education education) {
        Iterator<Person> iterator = personList.iterator();

        while (iterator.hasNext()) {
            Person nextPerson = iterator.next();

            if (nextPerson.getEducation() == education) System.out.println(nextPerson);
        }
    }

    public void fire(Education education) {
        Iterator<Person> iterator = personList.iterator();

        while (iterator.hasNext()) {
            Person nextPerson = iterator.next();

            if (nextPerson.getEducation() == education) iterator.remove();
        }
    }
}
