import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by shivpriyatamboskar on 10/5/16.
 *
 */
public class DoctorTest {

    ArrayList<Doctor> doctors;
    RelevantDoctors docs;
    HashMap<String, ArrayList<Doctor>> cityDoctor;
    ArrayList<Doctor> city1;
    ArrayList<Doctor> city2;
    ArrayList<Doctor> city3;
    ArrayList<Doctor> city4;

    Doctor testDoctor1;
    Doctor testDoctor2;

    Doctor d1;
    Doctor d2;
    Doctor d3;
    Doctor d4;
    Doctor d5;
    Doctor d6;
    Doctor d7;

    @org.junit.Before
    public void setUp() throws Exception {

        docs = new RelevantDoctors();
        doctors = new ArrayList<Doctor>();
        cityDoctor = new HashMap<String, ArrayList<Doctor>>();

        testDoctor1 = new Doctor("tim","dentist","San Jose","ca",40,4);
        testDoctor2 = new Doctor("lara","pediatrician","San Jose","ca",34,3);

        d1 = new Doctor("diana", "dentist", "Los Angeles","ca",42, 4);
        d2 = new Doctor("craig", "dermatologist", "San Jose","ca",34, 5);
        d3 = new Doctor("mark", "neurosurgeon", "New York","new york",40, 3);
        d4 = new Doctor("allen", "neurologist", "San Diego","ca",44, 2);
        d5 = new Doctor("Alice", "pediatrician", "San Jose","ca",45,1);
        d6 = new Doctor("clark", "dentist", "San Jose","ca",45,2);
        d7 = new Doctor("helen", "dentist", "San Jose","ca",45,3);

        doctors.add(d1);
        doctors.add(d2);
        doctors.add(d3);
        doctors.add(d4);
        doctors.add(d5);
        doctors.add(d6);
        doctors.add(d7);

        city1 = new ArrayList<Doctor>();
        city2 = new ArrayList<Doctor>();
        city3 = new ArrayList<Doctor>();
        city4 = new ArrayList<Doctor>();

        city1.addAll(Arrays.asList(d2,d5,d6,d7));
        city2.addAll(Arrays.asList(d3));
        city3.addAll(Arrays.asList(d4));
        city4.addAll(Arrays.asList(d1));

        cityDoctor.put("San Jose", city1);
        cityDoctor.put("New York", city2);
        cityDoctor.put("San Diego", city3);
        cityDoctor.put("Los Angeles", city4);

    }

    @Test
    public void testPrepProcessDoctors(){

        assertEquals(cityDoctor, docs.preProcessDoctors(doctors));
        assertEquals(null, docs.preProcessDoctors(null));
        assertEquals(null, docs.preProcessDoctors(new ArrayList<Doctor>()));

    }

    @Test
    public void testMostRelevant(){

        ArrayList<Doctor> result = new ArrayList<Doctor>();
        result.addAll(Arrays.asList(d7,d6));

        assertEquals(result,
                docs.mostRelevant(testDoctor1, cityDoctor.get(testDoctor1.city)));

        result.clear();
        result.addAll(Arrays.asList(d5));

        assertEquals(result,
                docs.mostRelevant(testDoctor2, cityDoctor.get(testDoctor2.city)));

    }


    @org.junit.After
    public void tearDown() throws Exception {

        doctors = null;
        docs = null;
        cityDoctor = null;
        city1 = null;
        city2 = null;
        city3 = null;
        city4 = null;

        testDoctor1 = null;
        testDoctor2 = null;

        d1 = null;
        d2 = null;
        d3 = null;
        d4 = null;
        d5 = null;
        d6 = null;
        d7 = null;
    }

}