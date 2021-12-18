class Student {
    String studentName;
    Integer studentID;
    String status;
    public Student(Integer studentID, String studentName) {
        this.studentName = studentName;
        this.studentID = studentID;
    }    
}

class ExceptionCheck {
    public String validateStudent(Student student) throws Exception {
        try {
            if (student.studentName == null || student.studentName.length() < 3) {
                throw new InvalidStudentException("Student name invalid");
            }
            if (student.studentID == null || student.studentID <= 100) {
                throw new InvalidStudentException("Student id invalid");
            }
            if (student.studentName.length() >= 3 && student.studentID > 100) {
                student.status = "success";
            }
        } catch (InvalidStudentException e) {
            student.status = e.getMessage();
            // throw new InvalidStudentException(student.status);
        } catch (Exception e) {
            throw new Exception("unknown error occured");
        }
        return student.status;
    }
}

class InvalidStudentException extends Exception {
    public InvalidStudentException(String msg) {
        super(msg);
    }
}

public class ExceptionHandling {
    public static void main(String[] args) throws Exception {
        ExceptionCheck e = new ExceptionCheck();
        System.out.println(e.validateStudent(new Student(null, "null")));
        System.out.println(e.validateStudent(new Student(1000, null)));
        System.out.println(e.validateStudent(new Student(122, "null")));
    }
}