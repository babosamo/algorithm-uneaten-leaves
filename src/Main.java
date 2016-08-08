import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("#1 " + (new EatLeaf(20, new Integer[]{2, 3, 5}).getUneatenLeaves() == 6));
        System.out.println("#2 " + (new EatLeaf(30, new Integer[]{2, 4, 5, 7}).getUneatenLeaves() == 10));
        System.out.println("#3 " + (new EatLeaf(40, new Integer[]{2, 3, 5, 11}).getUneatenLeaves() == 9));


//        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(new Integer[]{2,3,5}));
//        ArrayList<ArrayList<Integer>> resultArray = new ArrayList<>();
//        getCombination(resultArray, null, array, 0);
    }


    public static void getCombination(ArrayList<ArrayList<Integer>> resultArray, ArrayList<Integer> result, ArrayList<Integer> array, int index) {
        if (result == null) {
            result = new ArrayList<>();
        }

        for (int i = index; i < array.size(); i++) {
            ArrayList<Integer> temp = (ArrayList<Integer>) result.clone();
            temp.add(array.get(i));
            resultArray.add(temp);

            System.out.println(temp);
            if (index < array.size() - 1) {
                getCombination(resultArray, temp, array, i + 1);
            }
        }
    }
}
