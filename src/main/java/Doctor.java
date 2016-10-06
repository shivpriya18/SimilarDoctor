
/**
 *  Created by Shivpriya Tamboskar on 10/5/16.
 *
 *  Doctor POJO
 *
 */
public class Doctor {

    String name;             // assume here first name and last name included
    String specialization;
    String city;
    String state;
    int age;
    int rating;  // assume between 1-5

    public Doctor(String name, String specialization, String city, String state, int age, int rating){

        this.name = name;
        this.city = city;
        this.specialization = specialization;
        this.state = state;
        this.age = age;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", age=" + age +
                ", rating=" + rating +
                '}';
    }


}
