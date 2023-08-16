import java.util.ArrayList;

/**
 * <a href="https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf">最小的 K 个数</a>
 * @Author phoebe
 * @date 2021/3/24
 */
public class Leetcode_GetLeastNumbers {

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        int k = 4;
        System.out.println(getLeastNumbers(input, k));
    }

    public static ArrayList<Integer> getLeastNumbers(int [] input, int k) {
        if (k > input.length) {
            return new ArrayList<>();
        }

        int[] heap = new int[k];
        for (int i =  k / 2 - 1; i >= 0; i--) {
            heapify(input, k, i);
        }

        for (int i = k; i < input.length; i++) {
            if (input[i] < input[0]) {
                input[0] = input[i];
                heapify(input, k, 0);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return  result;
    }


    public static void heapify(int[] array, int len, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < len && array[left] > array[i]) {
            largest = left;
        }

        if (right < len && array[right] > array[i]) {
            largest = right;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, len, largest);
        }
    }
}