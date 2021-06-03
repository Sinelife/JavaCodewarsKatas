package rank6kyu;

import java.util.*;

public class TripleSortingListBy_3_Attributes {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(23, 88, "David Goodman"));
        students.add(new Student(25, 82, "Mark Rose"));
        students.add(new Student(22, 90, "Jane Doe"));
        students.add(new Student(25, 90, "Jane Dane"));
        System.out.println(students);
        System.out.println(sort(students));
    }


    public static String sort(List<Student> students) {
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int gpaDifference = o2.getGpa() - o1.getGpa();
                int letterDifference = firstLetterOfSurname(o1.getFullName()) - firstLetterOfSurname(o2.getFullName());
                int ageDifference = o1.getAge() - o2.getAge();
                return gpaDifference != 0 ? gpaDifference : (letterDifference != 0 ? letterDifference : ageDifference);
            }

            private int firstLetterOfSurname(String fullName) {
                return fullName.split(" ")[1].charAt(0);
            }
        });
        String res = "";
        for (Student student : students) {
            res += student.getFullName() + ",";
        }
        return res.substring(0, res.length() - 1);
    }
}


class Student {

    private int gpa;
    private int age;
    private String fullName;

    public Student(int age, int gpa, String fullName) {
        this.gpa = gpa;
        this.age = age;
        this.fullName = fullName;
    }

    public int getGpa() {
        return gpa;
    }

    public int getAge() {
        return age;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gpa=" + gpa +
                ", age=" + age +
                ", fullName='" + fullName + '\'' +
                "}\n";
    }
}
