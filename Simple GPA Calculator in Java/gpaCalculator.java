
public class gpaCalculator{

    public static void main (String [] args)
    {
        //take the input of the person for # of class
        System.out.print("Please enter the number of classes you are taking: ");

        Scanner input = new Scanner(System.in);
        int numClasses = input.nextInt();

        //declare the variables used in console for grades
        String letterGrades = "";

        //cumulation of GPA, used at the end
        int cumulGPA = 0;

        //single GPA value
        int addedGPA;

        for (int i = 0; i < numClasses; i++)
        {
            //let user enter the grade
            System.out.print("Please enter the letter grade you have achieved: ");
            Scanner letterInput = new Scanner(System.in);
            grades = letterInput.nextLine();

            //after entering letter, look at gpa value
            switch (grades){
                case "A":
                    addedGPA = 4;
                    cumulGPA += addedGPA;
                    break;
                case "B":
                    addedGPA = 3;
                    cumulGPA += addedGPA;
                    break;
                case "C":
                    addedGPA = 2;
                    cumulGPA += addedGPA;
                    break;
                case "D":
                    addedGPA = 1;
                    cumulGPA += addedGPA;
                    break;
                case "F":
                    addedGPA = 0;
                    cumulGPA += addedGPA;
                    break;
            }
        }
        //calculate the GPA
        double calculatedGPA = cumulGPA / numClasses;
        System.out.println(calculatedGPA);
    }

}