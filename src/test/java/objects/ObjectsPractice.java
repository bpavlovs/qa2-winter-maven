package objects;

import org.junit.jupiter.api.Test;

public class ObjectsPractice {

    @Test
    public void workingWithObjects() {

        Student pavel = new Student("Pavel", "Testirovich");

//        pavel.setFirstName("Pavel");
//        pavel.setLastName("Testerovich");

        pavel.setAge(80);
        pavel.setPhone(377222222222L);

        Student nadja = new Student("Nadezda", "Fig vam a ne ljubovj");

        nadja.setFirstName("Nadezhda");
        nadja.setLastName("Fig vam a ne ljubovj");
        nadja.setAge(69);
        nadja.setPhone("911");

        System.out.println("First Student: " + nadja.getFirstName() + " " + nadja.getLastName());
        System.out.println("Second Student: " + pavel.getFirstName() + " " + pavel.getLastName());

        System.out.println();

        System.out.println("First Student: " + nadja.getFullName());
        System.out.println("Second Student: " + pavel.getFullName());

    }

}
