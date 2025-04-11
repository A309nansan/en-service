package site.nansan.en.service.problem.enlv1s2c1;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum Person {

    person_low(0), person_mid(1), person_high(2);

    private final int index;

    public static Person getPerson(int index) {

        return INDEX_TO_ENUM.get(index);
    }

    private static final Map<Integer, Person> INDEX_TO_ENUM = new HashMap<>();

    static {
        for (Person person: values()) {
            INDEX_TO_ENUM.put(person.index, person);
        }
    }
}
