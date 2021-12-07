package practice;



public class LearnVariable {
     public void stringVariable() {
        String name = "Parvez";
        String city = "Philadelphia";
        String work = "Wells Fargo";
        System.out.println("My name is "+ name + ". I live in "+ city + ". I work for "+ work);
            }

     public void intVariable() {
        int age = 38;
        int salary = 105000;
        System.out.println("My age is :"+ age + " My salary is :" + salary);
             }

     public void characterVariable() {
        char FirstInitial = 'M';
        char SecondInitial = 'P';
        System.out.println("My first initial is -" + FirstInitial + " & my last initial is - " + SecondInitial);
            }

     public void floatVariable() {
         float TaxRate = 24.15f;
         System.out.println("My annual tax rate is " + TaxRate);
            }
     public void booleanVariable() {
         boolean daughter = true;
         boolean son = false;
         System.out.println("I have a daughter, which is " + daughter + ". I have a son, which is " + son);
     }

     public int addNumber() {
         int a = 1;
         int b = 5;
     int sum = a+b;
     return sum;
     }

     public int AddNumber(int a, int b) {
         int sum = a+b;
         return sum;
     }
}







