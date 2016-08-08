import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by babosamo on 2016. 8. 5..
 */
public class EatLeaf {

    private int leaves;
    private Integer[] numbers;
    private int uneatenLeaves;

    public EatLeaf(int leaves, Integer[] numbers) {
        this.leaves = leaves;
        this.numbers = numbers;
        this.uneatenLeaves = leaves;


        ArrayList<Integer> array = multipleFilter(new ArrayList<Integer>(Arrays.asList(numbers)));

        ArrayList<ArrayList<Integer>> resultArray = new ArrayList<>();
        getCombination(resultArray, null, array, 0);
    }


    public int getUneatenLeaves() {
        return uneatenLeaves;
    }

    private ArrayList<Integer> multipleFilter(ArrayList<Integer> arrayList) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int value : arrayList) {
            boolean hasMultiple = false;

            for(int temp : result){
                if(value > temp && value % temp == 0){
                    hasMultiple = true;
                    System.out.println("filter " + value + " skip cause by " + temp);
                }
            }

            if (!hasMultiple){
                result.add(value);
            }
        }


        return result;
    }

    private void getCombination(ArrayList<ArrayList<Integer>> resultArray, ArrayList<Integer> result, ArrayList<Integer> array, int index) {
        if (result == null) {
            result = new ArrayList<>();
        }

        for (int i = index; i < array.size(); i++) {
            ArrayList<Integer> temp = (ArrayList<Integer>) result.clone();
            temp.add(array.get(i));
            resultArray.add(temp);
            doEat(temp);
            if (index < array.size() - 1) {
                getCombination(resultArray, temp, array, i + 1);
            }
        }
    }

    private void doEat(ArrayList<Integer> result) {

        System.out.println("uneatenLeaves: " + uneatenLeaves + ", values: " + result);
        int value = 1;
        for (int temp : result) {
            value *= temp;
        }

        int leafCount = (leaves / value);
        if (result.size() % 2 == 1) {
            uneatenLeaves -= leafCount;
            System.out.println(" - " + leafCount + " --> " + uneatenLeaves);
        } else {
            uneatenLeaves += leafCount;
            System.out.println(" + " + leafCount + " --> " + uneatenLeaves);
        }


    }
}
