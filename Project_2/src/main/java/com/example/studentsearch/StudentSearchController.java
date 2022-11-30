package com.example.studentsearch;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentSearchController {

    List<Student> sl ;

    @PostConstruct
    public void student() {
        sl = new ArrayList<>();
        sl.add(new Student(1,"Caleb",3.6,"jdtg0@aws.com","Female"));
        sl.add(new Student(2,"Aida",3.1,"adattt@test.gov","Female"));
        sl.add(new Student(3,"Alex",3.4,"Adavis@bccs.com","Male"));
        sl.add(new Student(4,"Meba",3.2,"mtravis@yahoo.com","Male"));

    }

   // http://localhost:8080/student/getAll
    @RequestMapping("getAll")
    public List<Student> getAllStudent(){
        return sl;
    }


    // http://localhost:8080/student/getByName?name=Aida
    @RequestMapping("getByName")
    public List<Student> getByName(@RequestParam("name") String name){
        List<Student> matchedStudents = new ArrayList<Student>();
        for(Student currentStudent : sl) {
            if(currentStudent.getName().equalsIgnoreCase(name)) {
                matchedStudents.add(currentStudent);
            }
        }
        return matchedStudents;
    }


    //http://localhost:8080/student/getByGpaAndGender?gpa=3.4&gender=Male
    @RequestMapping("getByGpaAndGender")
    public List<Student> getByGpaAndGender(@RequestParam("gpa") double gpa, @RequestParam("gender") String gender){
        List<Student> matchedStudents = new ArrayList<Student>();
        for(Student currentStudent : sl) {
            if(currentStudent.getGpa()==gpa && currentStudent.getGender().equalsIgnoreCase(gender)) {
                matchedStudents.add(currentStudent);
            }
        }
        return matchedStudents;
    }

    // http://localhost:8080/student/getAvgGpa
    @RequestMapping("getAvgGpa")
    public double getAvgGpa() {
        double totalGpa = 0;
        int count = 0;
        double avgGpa = 0;
        for(Student currentStudent : sl) {
            count++;
            totalGpa += currentStudent.getGpa();
        }
        if(count>0) {
            avgGpa = totalGpa/count;
        }
        return avgGpa;
    }
}
