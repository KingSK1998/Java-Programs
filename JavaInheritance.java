import java.util.ArrayList;
class Student{}
class Rockstar{}
class Hacker{}

class JavaInheritance {   
    public static void main(String[] args) {
        ArrayList mylist = new ArrayList();
        mylist.add(new Student());
        mylist.add(new Student());
        mylist.add(new Rockstar());
        mylist.add(new Student());
        mylist.add(new Hacker());
        int a = 0,b = 0,c = 0;
        for(int i = 0; i < mylist.size(); i++){
            Object element=mylist.get(i);
            if(element instanceof Student)
                a++;
            if(element instanceof Rockstar)
                b++;
            if(element instanceof Hacker)
                c++;
        }
        System.out.println(a + " " + b  + " " + c);
        
        
        // MyCalculator myCalculator = new MyCalculator();
        // int n = 6;
        // System.out.println(myCalculator.divisor_sum(n));
        
        // MyBook novel = new MyBook();
        // String title = "A tale of two cities";
        // novel.setTitle(title);
        // System.out.println("The title is: "+novel.getTitle());
    }
}

// interface AdvancedArithmetic{
//   int divisor_sum(int n);
// }

//Write your code here
// class MyCalculator implements AdvancedArithmetic{
//     public int divisor_sum(int n) {
//         int sum = 0;
//         for(int i = 1; i <= n; i++)
//             if(n%i == 0)
//                 sum += i;
//         return sum;
//     }
// }


// Abstract Class: 
//      ->  can't be instantiated 
//      ->  (cannot create new instances)
//      ->  works as a base for subclasses
// abstract class Book {
    //     String title;
    //     abstract void setTitle(String s);
    //     String getTitle() {
        //         return title;
//     }
// }
// class MyBook extends Book{
// setTitle must be implemented as abstract method
//     void setTitle(String s) {
//         this.title = s;
//     }
// }