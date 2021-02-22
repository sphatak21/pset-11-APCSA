import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ProblemSet11 {

    public static void main(String[] args) {

    }

    public ArrayList<String> fizzBuzz(int start, int end) {
        if(start > end){
            return null;
        }
        String[] arr = new String[end - start];
        int index = 0;

        for(int i = start; i < end; i++){
            String appendString = "";
            if(i%3 == 0){
                appendString += "Fizz";
            }
            if(i%5 == 0){
                appendString += "Buzz";
            }
            if(appendString.length() == 0){
                appendString = Integer.toString(i);
            }
            arr[index] = appendString;
            index++;
        }
        return (ArrayList<String>) Arrays.asList(arr);
    }

    public int maxSpan(ArrayList<Integer> numbers) {
        if(numbers == null){
            return -1;
        }

        int maxSpan = 0;
        while (numbers.size() > 0){
            for(int i = 1; i< numbers.size(); i ++){
                if(numbers.get(0).equals(numbers.get(i))) {
                    if(i + 1 > maxSpan){
                        maxSpan = i + 1;
                    }
                }
            }
            int tempBool = 0;
            int removingVal = numbers.get(0);
            while(tempBool >= 0){
                tempBool=numbers.remove(removingVal);
            }
        }
        return maxSpan;
    }

    public ArrayList<Integer> fix34(ArrayList<Integer> numbers) {
        if(numbers == null){
            return null;
        }
        int threeCount = 0;
        ArrayList<Integer> threeIndexes = new ArrayList<>();
        int fourCount = 0;
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) == 3){
                if(numbers.get(i + 1) == 4){
                    return null;
                }
                threeCount++;
                threeIndexes.add(i);
            }
            if(numbers.get(i) == 4){
                if(threeCount == 0){
                    return null;
                }
                fourCount++;
            }
        }
        if(threeCount != fourCount){
            return null;
        }
        int[] arr = new int[numbers.size()];
        for(int j : threeIndexes){
            arr[j] = 3;
            arr[j+1] = 4;
        }
        for(int k : numbers){
            for(int l = 0; l < arr.length; l++){
                if(arr[l] == 0 && k !=3 && k !=4){
                    arr[l] = k;
                }
            }
        }
        ArrayList<Integer> returnarr = new ArrayList<>();
        for(int i : arr){
            returnarr.add(i);
        }
        return returnarr;
    }

    public ArrayList<Integer> fix45(ArrayList<Integer> numbers) {
        if(numbers == null){
            return null;
        }
        int fourCount = 0;
        ArrayList<Integer> fourIndexes = new ArrayList<>();
        int fiveCount = 0;
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) == 4){
                if(numbers.get(i + 1) == 5){
                    return null;
                }
                fourCount++;
                fourIndexes.add(i);
            }
            if(numbers.get(i) == 5){
                fiveCount++;
            }
        }
        if(fourCount != fiveCount){
            return null;
        }
        int[] arr = new int[numbers.size()];
        for(int j : fourIndexes){
            arr[j] = 4;
            arr[j+1] = 5;
        }
        for(int k : numbers){
            for(int l = 0; l < arr.length; l++){
                if(arr[l] == 0 && k !=4 && k !=5){
                    arr[l] = k;
                }
            }
        }
        ArrayList<Integer> returnarr = new ArrayList<>();
        for(int i : arr){
            returnarr.add(i);
        }
        return returnarr;
    }

    public boolean canBalance(ArrayList<Integer> numbers) {
        int sum = 0;
        int halfSum = 0;
        for(int i : numbers){
            sum += i;
        }
        for(int j : numbers){
            if(halfSum <= sum/2){
                halfSum+=j;
            }else {
                return halfSum == sum / 2;
            }
        }
        return false;
    }

    public boolean linearIn(ArrayList<Integer> outer, ArrayList<Integer> inner) {
        for(int i : inner){
            boolean exists = false;
            for(int k : outer){
                if(i == k){
                    exists = true;
                    break;
                }
            }
            if(!exists){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> squareUp(int n) {
        if(n < 0){
            return null;
        }
        ArrayList<Integer> totalarr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int[] smallarr = new int[n];
            int numadditions = 0;
            for(int j = n - 1; j >=0; j--){
                if(numadditions < i + 1){
                    smallarr[j] = numadditions + 1;
                    numadditions++;
                }
            }
            for(int x : smallarr){
                totalarr.add(x);
            }
        }
        return totalarr;
    }

    public ArrayList<Integer> seriesUp(int n) {
        if(n < 0 ){
            return null;
        }
        ArrayList<Integer> totalarr = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            for(int j = 1; j < i + 1; j ++){
                totalarr.add(j);
            }
        }
        return totalarr;
    }

    public int maxMirror(ArrayList<Integer> numbers) {
        if(numbers == null){
            return -1;
        }
        for (int i = numbers.size(); i > 0; i--){
            ArrayList<int[]> arrayList = new ArrayList<>();
            for(int j = 0; j < numbers.size(); j++){
                try {
                    int[] sublist = makeSublist(numbers, j, j + i);
                    arrayList.add(sublist);
                } catch (ArrayIndexOutOfBoundsException e){
                    break;
                }
            }
            while(arrayList.size() > 0){
                for (int[] ints : arrayList) {
                    if (compareReverseLists(arrayList.get(0), ints)) {
                        return i;
                    }
                }
                arrayList.remove(0);
            }
        }
        return 0;
    }

    public int countClumps(ArrayList<Integer> numbers) {
        if(numbers == null){
            return -1;
        }
        boolean inClump = false;
        int numClumps = 0;
        for(int i = 0; i < numbers.size()-1; i++){
            if(numbers.get(i).equals(numbers.get(i + 1))){
                if(!inClump){
                    numClumps++;
                    inClump = true;
                }
            }else {
                inClump = false;
            }
        }
        return numClumps;
    }

    private int[] makeSublist (ArrayList<Integer> arr, int start, int end){
        if(end < start){
            return null;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = start; i < end; i++){
            temp.add(arr.get(i));
        }
        return temp.stream().mapToInt(i -> i).toArray();
    }

    private boolean compareReverseLists(int[] list1, int[] list2){
        for(int i = 0; i < list1.length; i ++){
            if(list1[i] != list2[list2.length - 1 - i]){
                return false;
            }
        }
        return true;
    }
}
