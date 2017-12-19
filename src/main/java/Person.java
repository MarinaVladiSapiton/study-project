import java.util.Comparator;

/**
 * Created by Марина on 15.12.2017.
 */
public class Person {
    String name;
    int age;
    int weight;

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public Person(String name, int age, int weight){
        this.name=name;
        this.age=age;
        this.weight=weight;

    }

    public static final Comparator<Person> COMPARE_BY_AGE_AND_WEGHT = new Comparator<Person>() {

        public int compare(Person left, Person right) {
            if(left.getAge() - right.getAge()==0) return left.getWeight() - right.getWeight();
            return left.getAge() - right.getAge();
        }
    };


}
