import java.util.Arrays;

/**
 * Created by mayalake on 10/23/18.
 * Use sorted array as set
 */
public class SetB<T extends Comparable<T>>{
    private T[] values;

    public SetB(T[] values){
        Arrays.sort(values);
        this.values = values;
    }

    public SetB union(SetB<T> set){
        T[] unionVals = Arrays.copyOf(values, values.length+set.values.length);
        int pointer = values.length;
        int idxA =0, idxB = 0;

        while (idxA < values.length && idxB < set.values.length){
            if (values[idxA].compareTo(set.values[idxB]) < 0){
                idxA++;
            }
            else if (values[idxA].compareTo(set.values[idxB]) > 0){
                unionVals[pointer] = set.values[idxB];
                pointer++;
                idxB++;
            } else{
                idxA++;
                idxB++;
            }
        }

        while (idxB < set.values.length){
            unionVals[pointer] = set.values[idxB];
            pointer++;
            idxB++;
        }

        return new SetB(Arrays.copyOf(unionVals, pointer));
    }

    public SetB intersection(SetB<T> set){
        T[] intersectionVals = Arrays.copyOf(values, values.length+set.values.length);
        int pointer = 0, idxA = 0, idxB = 0;

        while (idxA < values.length && idxB < set.values.length){
            if (values[idxA].compareTo(set.values[idxB]) < 0){
                idxA++;
            }
            else if (values[idxA].compareTo(set.values[idxB]) > 0){
                idxB++;
            } else{
                intersectionVals[pointer] = set.values[idxB];
                pointer++;
                idxA++;
                idxB++;
            }
        }

        return new SetB(Arrays.copyOf(intersectionVals, pointer));
    }

    public SetB difference(SetB<T> set){
        T[] differenceVals = Arrays.copyOf(values, values.length+set.values.length);
        int pointer = 0, idxA = 0, idxB = 0;

        while (idxA < values.length && idxB < set.values.length){
            if (values[idxA].compareTo(set.values[idxB]) < 0){
                differenceVals[pointer] = values[idxA];
                pointer++;
                idxA++;
            }
            else if (values[idxA].compareTo(set.values[idxB]) > 0){
                differenceVals[pointer] = set.values[idxB];
                pointer++;
                idxB++;
            } else{
                idxA++;
                idxB++;
            }
        }

        while (idxB < set.values.length){
            differenceVals[pointer] = set.values[idxB];
            pointer++;
            idxB++;
        }

        while (idxA < values.length){
            differenceVals[pointer] = values[idxA];
            pointer++;
            idxA++;
        }

        return new SetB(Arrays.copyOf(differenceVals, pointer));
    }


    public String toString(){
        return Arrays.toString(values);
    }
}
