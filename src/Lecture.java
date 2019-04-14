
import java.util.Scanner;
import java.util.ArrayList;
public class Lecture {

    Scanner input = new Scanner (System.in);

    protected int lectureID;
    protected String name;
    protected Lecturer lecturer;
    protected User user; //BU DA YEN� //
    protected ArrayList<Student> studentsList;
    protected Grade grade;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLectureID() {
        return lectureID;
    }

    public void setLectureID(int lectureID) {
        if (lectureID <= 0)  //DE���T� //
            lectureID = 0; //DE���T�//
        else
            this.lectureID = lectureID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }


    public Lecture(int ID, String name, Lecturer lecturer, ArrayList<Grade> gradeList ) {
        setLectureID(ID);
        setName(name);
        setLecturer(lecturer);

    }
    public Lecture(int ID, User user) { //BU CONSTRUCTOR GEREKL�YD� //
        setLectureID(ID);
        setUser(user); //BUNU YEN� KOYDUM //
        ArrayList<Grade> gradeList = new ArrayList<Grade>();



    }

    public Lecture(int ID, String name, Lecturer lecturer) {
        setLectureID(ID);
        setName(name);
        this.lecturer = lecturer;

    }


    public Lecture(int ID, String name) {

    }


    public void printInfo(){
        System.out.println("Lecture ID: "+getLectureID());
        System.out.println("Lecture name: "+getName());
        System.out.println("Lecturer of this lecture: "+getLecturer().getFullName());


    }

}
