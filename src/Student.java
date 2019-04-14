import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User {
    Scanner input = new Scanner(System.in);

    protected String departmentName;
    protected ArrayList<Lecture> lecturesList= new ArrayList<Lecture>();
    protected ArrayList<Grade> gradeList =  new ArrayList<Grade>();


    public void setDepartmentName(String departmentName) {

        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public ArrayList<Lecture> getLecturesList() {
        return lecturesList;
    }

    public void setLecturesList(ArrayList<Lecture> lecturesList) {
        this.lecturesList = lecturesList;
    }


    public Student(int ID, String password,String fullName, String departmentName) {
        this.ID = ID;
        this.password = password;
        this.fullName = fullName;
        this.departmentName = departmentName;

    }


    public Student(){
        super();
        setDepartmentName("No department.");
    }

    public Student(int ID, String password,String fullName, String departmentName,ArrayList<Lecture> lecturesList, ArrayList<Grade> gradeList){
        super(ID,password,fullName);
        setDepartmentName(departmentName);
        lecturesList= new ArrayList<Lecture>();
        gradeList =  new ArrayList<Grade>();

    }

    @Override


    public void printInfo(){
        System.out.println("Student ID number: "+getID());
        System.out.println("Full name: "+getFullName());
        System.out.println("Department: "+getDepartmentName());

        for (int j = 0; j < gradeList.size(); j++) {
            gradeList.get(j).displayGrade();
        }

    }


}




