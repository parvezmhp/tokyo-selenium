package practice;
// Publish grades for the class
public class LearnSwitchCondition {
    public void switchS(char grade) {
        switch (grade) {
            case 'A':
                System.out.println("Excellent");
                break;
            case 'B':
                System.out.println("Very good");
            case 'C':
                System.out.println("Very good");
                break;
            case 'D':
                System.out.println("Pass");
                break;
            case 'F':
                System.out.println("Fail");
                break;
            default:
                System.out.println("Invalid Grade");
        }

        System.out.println("Your Final Grade is: " + grade);
    }

    public void printgrade(char grade) {
        if (grade == 'A') {
            System.out.println("Excellent");
        } else if (grade == 'B' || grade == 'C') {
            System.out.println("Very Good");
        } else if (grade == 'D') {
            System.out.println("Pass");
        } else if (grade == 'F') {
            System.out.println("Fail");}
        else
            System.out.println("Invalid Grade");
        System.out.println("Your Final Grade is: " + grade);}
    }








