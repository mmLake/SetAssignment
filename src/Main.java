import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

//
//        SetA s = new SetA(new ArrayList<>(Arrays.asList(0,1,2,3)));
//        SetA s2 = new SetA(new ArrayList<>(Arrays.asList(0,2,3,4)));



        SetB<Integer> s = new SetB(new Integer[]{0,1,2,3,8,9});
        SetB<Integer> s2 = new SetB(new Integer[]{0,2,3,4,7});

        System.out.println(s.union(s2).toString());
        System.out.println(s.intersection(s2).toString());
        System.out.println(s.difference(s2).toString());


//        welcomeMessage();
//
//        exitMessage();

    }

    public static void welcomeMessage(){
        System.out.printf("This program can test set operations\n"+
                "Menu: \n"+
                "(0) Exit program\n"+
                "(1) Union 2 sets\n"+
                "(2) Intersect 2 sets\n"+
                "(3) Find difference of 2 sets\n");
    }

    public static void exitMessage(){
        System.out.printf("Program is exiting\n");
    }

    public static void menu(){
        int choice = -1;
        while(choice != 0){
            choice = Driver.getMenuOption();

            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }
    }


}
