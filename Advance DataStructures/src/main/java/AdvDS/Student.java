package AdvDS;

public class Student {
    private String name;
    private String roll_no;
    private double cgpa;
    // CONSTRUCTOR
    public Student(String name, String roll_no, double cgpa) {
        this.name = name;
        this.roll_no = roll_no;
        this.cgpa = cgpa;
    }
    // PROPERTIES
    public void setName(String name)        { this.name = name;         }
    public String getName()                 { return name;              }
    public void setRoll_no(String roll_no)  { this.roll_no = roll_no;   }
    public String getRoll_no()              { return roll_no;           }
    public void setCgpa(double cgpa)        { this.cgpa = cgpa;         }
    public double getCgpa()                 { return cgpa;              }
    // METHODS
    public String toString() {
        return "Name: "+name+"\tRoll no: "+roll_no+"\tCGPA: "+cgpa;
    }
}