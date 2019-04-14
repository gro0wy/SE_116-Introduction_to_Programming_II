import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void managerMenu() {
        System.out.println("****MANAGER MENU****");
        System.out.println("Which one do you want to add to the system?");
        System.out.println("ENTER 1 TO ADD A NEW STUDENT");
        System.out.println("ENTER 2 TO ADD A NEW LECTURER");
        System.out.println("ENTER 3 TO ADD A NEW LECTURE");
        System.out.println("ENTER 0 TO GO BACK");
        System.out.print("Choice? :");

    }

    public static void loginMenu() {
        System.out.println("***Welcome to our Student Information System!***");
        System.out.println("ENTER ANY NUMBER TO LOGIN");
        System.out.println("ENTER 0 TO TERMINATE THE SYSTEM");
        System.out.print("Choice? :");


    }

    public static void displayMenu() {
        System.out.println("***SIGN IN*** ");
        System.out.println("ENTER 1 TO SIGN IN AS STUDENT ");
        System.out.println("ENTER 2 TO SIGN IN AS LECTURER ");
        System.out.println("ENTER 3 TO SIGN IN AS MANAGER ");
        System.out.println("ENTER 0 TO GO BACK TO THE MAIN MENU");
        System.out.print("Choice? :");

    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        int choice2;
        int choice3;
        int counter;
        int tempID;
        int tempLectureID;
        String tempName;
        String tempPassword;
        String tempDepartment;
        String tempFullName;
        double tempMidtermGrade;
        double tempFinalGrade;
        double tempQuizGrade;
        double tempHomeworkGrade;
        float tempSalary;
        Lecturer lecturerRef = new Lecturer();

        int managerID = 123;
        String managerPassword = "admin";
        ArrayList<Student> studentsList = new ArrayList<Student>();
        ArrayList<User> userList = new ArrayList();
        ArrayList<Lecture> lecturesList = new ArrayList<Lecture>();
        ArrayList<Grade>  gradeList = new ArrayList<Grade>();

        Student s1 = new Student(123, "naz", "Naz Tekinalp", "Computer Engineering");
        Student s2 = new Student(345, "meert", "Mert Kesimli", "Computer Engineering ");
        Student s3 = new Student(678, "mehmet", "Mehmet Emin Cesitli", "Computer Engineering");
        Student s4 = new Student (567, "dilara", "Dilara Gebes", "Software Engineering");
        Lecturer lr1 = new Lecturer(123, "ilker",  "Ilker Korkmaz" , 5000);
        Lecturer lr2 = new Lecturer(3459, "nazan", "Nazan Gurkan", 3000);
        Lecturer lr3 = new Lecturer (4789, "sevin" , "Sevin Gumgum", 6000);
        Lecturer lr4 = new Lecturer(1123, "nimer" , "Nimet Kardes Sever", 2000);
        Lecture l1 = new Lecture (456, "SE116", lr1);
        Lecture l2 = new Lecture(111, "GER102", lr2);
        Lecture l3 = new Lecture(222, "MATH154", lr3);
        Lecture l4 = new Lecture (999, "PHYS101", lr4);

        studentsList.add(s1);
        studentsList.add(s2);
        studentsList.add(s3);
        studentsList.add(s4);
        userList.add(lr1);
        userList.add(lr2);
        userList.add(lr3);
        userList.add(lr4);
        lecturesList.add(l1);
        lecturesList.add(l2);
        lecturesList.add(l3);
        lecturesList.add(l4);





        while (true) {   //LOGIN//
            loginMenu();
            choice = input.nextInt();
            if(choice == 0) {
                System.exit(0);
            }
            displayMenu();
            choice2 = input.nextInt();
            input.nextLine();
            while (choice2 != 0){
                switch (choice2) { //2//
                    case 1: //STUDENT//
                        System.out.println("Student ID: ");
                        tempID = input.nextInt();
                        input.nextLine();
                        System.out.println("Student Password: ");
                        tempPassword = input.nextLine();

                        for (int i=0; i<studentsList.size(); i++) {
                            if (tempID == studentsList.get(i).getID() && tempPassword.equals(studentsList.get(i).getPassword())) {
                                System.out.println("Welcome " + studentsList.get(i).getFullName());
                                studentsList.get(i).printInfo();
                            }

                        }

                        break;

                    case 2: //LECTURER//

                        System.out.println("Lecturer ID: ");
                        tempID = input.nextInt();
                        input.nextLine();
                        System.out.println("Lecturer Password: ");
                        tempPassword = input.nextLine();

                        for (int i=0; i<userList.size(); i++) {
                            if (tempID == userList.get(i).getID() && tempPassword.equals(userList.get(i).getPassword())) {
                                System.out.println("Welcome " + userList.get(i).getFullName());
                                userList.get(i).printInfo();  //RUN-TIME POLYMORPHISM//

                                System.out.println("***GRADE MENU****");
                                System.out.println("Plese enter the ID of your lecture: ");
                                tempLectureID = input.nextInt();
                                input.nextLine();

                                for( i=0; i< lecturesList.size(); i++) {
                                    Lecture lec1 = new Lecture(tempLectureID, userList.get(i));
                                    if (tempLectureID == lecturesList.get(i).getLectureID()) {
                                        lecturesList.get(i).printInfo();
                                        System.out.println("Please enter the ID of your student: ");
                                        tempID = input.nextInt();
                                        for (Student st : studentsList) {
                                            if (tempID == st.getID()) {
                                                System.out.println("Student : " + st.getFullName());
                                                System.out.println("Please enter the number of grades: ");
                                                counter = input.nextInt();
                                                input.nextLine();

                                                for (int j = 1; j <= counter; j++) {
                                                    System.out.println("HOMEWORK GRADE " + j + ":");
                                                    tempHomeworkGrade = input.nextDouble();
                                                    input.nextLine();
                                                    System.out.println("QUIZ GRADE " + j + ":");
                                                    tempQuizGrade = input.nextDouble();
                                                    input.nextLine();
                                                    System.out.println("MIDTERM GRADE " + j + ":");
                                                    tempMidtermGrade = input.nextDouble();
                                                    input.nextLine();
                                                    System.out.println("FINAL GRADE " + j + ":");
                                                    tempFinalGrade = input.nextDouble();
                                                    input.nextLine();

                                                    Grade gradeRef = new Grade(tempMidtermGrade, tempFinalGrade, tempQuizGrade, tempHomeworkGrade, lecturesList.get(i));

                                                    st.gradeList.add(gradeRef);
                                                    gradeRef.displayGrade();


                                                }


                                            }
                                        }
                                    }
                                }
                            }

                        }



                        break;


                    case 3: //MANAGER//
                        System.out.println("Manager ID: ");
                        tempID = input.nextInt();
                        input.nextLine();
                        System.out.println("Manager Password: ");
                        tempPassword = input.nextLine();
                        if (tempID == managerID && tempPassword.equals(managerPassword)) {
                            System.out.println("You have signed in as manager.");
                            managerMenu();

                            choice3 = input.nextInt();
                            input.nextLine();
                            while (choice3 != 0){
                                switch (choice3) { //3//

                                    case 1:
                                        System.out.println("You have chosen to add a new STUDENT!");
                                        System.out.println("Student ID: ");
                                        tempID = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Student password: ");
                                        tempPassword=input.nextLine();
                                        System.out.println("Student's Full name: ");
                                        tempFullName = input.nextLine();

                                        System.out.println("Student's Department: ");
                                        tempDepartment = input.nextLine();

                                        Student st1 = new Student(tempID, tempPassword,tempFullName, tempDepartment);
                                        studentsList.add(st1);
                                        System.out.println("Student successfully added!");

                                        break;


                                    case 2:
                                        System.out.println("You have chosen to add a new LECTURER!");
                                        System.out.println("Lecturer ID: " );
                                        tempID = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Lecturer password: ");
                                        tempPassword=input.nextLine();
                                        System.out.println("Lecturer Name: ");
                                        tempFullName = input.nextLine();
                                        System.out.println("Salary: ");
                                        tempSalary = input.nextFloat();
                                        input.nextLine();

                                        Lecturer le1 = new Lecturer(tempID, tempPassword, tempFullName, tempSalary);
                                        userList.add(le1);
                                        System.out.println("Lecturer successfully added!");
                                        break;

                                    case 3:
                                        System.out.println("You have chosen to add a new LECTURE!");
                                        System.out.println("Lecture ID: ");
                                        tempID = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Lecture Name: ");
                                        tempName = input.nextLine();
                                        System.out.println("Enter the id of the lecturer of this lecture: "  );
                                        tempID= input.nextInt();
                                        input.nextLine();
                                        for (int i=0; i< userList.size(); i++){
                                            if (tempID==userList.get(i).getID()){
                                                Lecture lec1 = new Lecture(tempID,tempName,lecturerRef);
                                                lecturesList.add(lec1);
                                                System.out.println("Lecture successfully added!");
                                            }


                                        }
                                        break;
                                    default:
                                        System.out.println("Wrong choice. Please try again.");
                                        break;


                                }
                                managerMenu();
                                choice3= input.nextInt();
                                input.nextLine();
                            }
                        }


                        break;

                    default:

                        break;

                }
                displayMenu();
                choice2= input.nextInt();
                input.nextLine();
            }




        }

    }
}