package compare;

import java.util.Comparator;

public class ComparatorPeopleByAge implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        int result = first.getAge()-second.getAge();

        return result;
    }
}
