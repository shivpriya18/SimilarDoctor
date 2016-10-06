import java.util.*;

/**
 * Created by shivpriyatamboskar on 10/5/16.
 *
 * Relevant Doctors.
 * The list of doctors is first pre processed to map each doctor to their city. Assumption here is no two different
 * states or country will have  a city with the same name.
 *
 * After the pre processing step, for a given input doctor we can retrieve the doctors for that city in constant
 * time.
 *
 * pre processing is useful if we are going to hold the list of all doctors in the memory. But if like in the real world
 * applications the list is maintained in a database like a relational database the step can be
 * completely avoided.
 *
 * After which we can do a match on the specialization of the doctor and return a sorted list of those doctors based on
 * their ratings.
 *
 * Improvement: -
 *
 * In this program we return doctors based on the specialization and ratings.
 * It could be made better by considering the zipcode of the given doctor. Zipcodes can be used to retrieve
 * latitudes and longitudes which can help in retrieving all the doctors in say a 50 mile radius.
 *
 */
public class RelevantDoctors {

    /**
     * Preprocessing step to group all doctors that belong to the same city.
     * @param doctors
     * @return
     */
    public HashMap<String, ArrayList<Doctor>> preProcessDoctors(ArrayList<Doctor> doctors){

        if(doctors == null || doctors.isEmpty())
            return null;

        HashMap<String, ArrayList<Doctor>> cityDoctor = new HashMap<String, ArrayList<Doctor>>();

        for(Doctor d: doctors){

            ArrayList<Doctor> temp;
            if(cityDoctor.containsKey(d.city)){

                temp = cityDoctor.get(d.city);
                temp.add(d);
            }
            else{

                temp = new ArrayList<Doctor>();
                temp.add(d);
                cityDoctor.put(d.city, temp);
            }

        }

        return cityDoctor;

    }


    /**
     *
     * Check to see if the specialization is the same.
     * @param s1
     * @param s2
     * @return
     */
    private boolean specialityCheck(String s1, String s2){

        return s1.equals(s2);

    }

    /**
     *
     * Create a list of doctors with the same specialization and sort them according to their rating
     * @param myDoctor
     * @param doctorList
     * @return
     */

    public ArrayList<Doctor> mostRelevant(Doctor myDoctor, List<Doctor> doctorList){

        ArrayList<Doctor> relevantDoctors = new ArrayList<Doctor>();

        for(Doctor doc: doctorList){

            if(specialityCheck(doc.specialization, myDoctor.specialization))
                relevantDoctors.add(doc);

        }

        Collections.sort(relevantDoctors, new Comparator<Doctor>() {
            public int compare(Doctor o1, Doctor o2) {
                return o2.rating - o1.rating;
            }
        });


        return relevantDoctors;

    }


    public static void main(String []args){

        RelevantDoctors docs = new RelevantDoctors();

        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        Doctor myDoctor = new Doctor("tom", "dentist", "San Jose","ca",40, 1);

        doctors.add(new Doctor("diana", "dentist", "Los Angeles","ca",42, 4));
        doctors.add(new Doctor("craig", "dermatologist", "San Jose","ca",34, 5));
        doctors.add(new Doctor("mark", "neurosurgeon", "New York","new york",40, 3));
        doctors.add(new Doctor("allen", "neurologist", "San Diego","ca",44, 2));
        doctors.add(new Doctor("Alice", "pediatrician", "San Jose","ca",45,1));
        doctors.add(new Doctor("clark", "dentist", "San Jose","ca",45,2));


        HashMap<String, ArrayList<Doctor>> cityDoctor = docs.preProcessDoctors(doctors);

        ArrayList<Doctor> relevantDoctors = docs.mostRelevant(myDoctor, cityDoctor.get(myDoctor.city));


        for(Doctor dr: relevantDoctors){

            System.out.println(dr.toString());
        }


    }



}
