import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by mayalake on 10/23/18.
 */
public class Driver {
    private static Scanner sc = new Scanner(System.in);

    public static int getMenuOption(){

        int response = -1;
        do {

            System.out.print("Enter a menu option: ");
            response = sc.nextInt();
            System.out.println();
        }while(response < 0 || response > 3);

        return response;
    }

    public static ArrayList<Object> getSetType1(){
        ArrayList<Object> set = new ArrayList<>();
        do {
            System.out.printf("Enter a set of objects. Separate each object with a space and hit enter once set is complete");
            set.addAll(Arrays.asList(sc.nextLine().split(" ")));
        }while(set.size() == 0);

        return set;
    }


}
