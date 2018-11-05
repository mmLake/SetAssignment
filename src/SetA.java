import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by mayalake on 10/23/18.
 * Use Arraylist as a set
 */
public class SetA<T> {
    private ArrayList<T> values;

    public SetA(ArrayList<T> values){
        this.values = values;
    }

    public SetA union(SetA set){
        ArrayList<T> allValues = new ArrayList<>();
        ArrayList<T> unionValues = new ArrayList<>();

        allValues.addAll(this.values);
        allValues.addAll(set.values);

        unionValues.addAll(allValues.stream().distinct().collect(Collectors.toList()));

        return new SetA(unionValues);
    }

    public SetA intersection(SetA<T> set){
        ArrayList<T> intersectionValues = new ArrayList<>();

        for (T item : set.values){
            if (this.values.contains(item)){
                intersectionValues.add(item);
            }
        }

        return new SetA(intersectionValues);
    }

    public SetA difference(SetA<T> set){
        ArrayList<T> differenceValues = new ArrayList<>();
        differenceValues.addAll(this.values);

        for (T item : set.values){
            if (this.values.contains(item)){
                differenceValues.remove(item);
            } else {
                differenceValues.add(item);
            }
        }

        return new SetA(differenceValues);
    }

    public String toString(){
        return values.toString();
    }
}
