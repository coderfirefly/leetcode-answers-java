import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations/">全排列</a>
 */
public class Leetcode_46_permutations {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> perm, int[] nums) {
        if (nums.length == perm.size()) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (perm.contains(nums[i])) {
                continue;
            }

            perm.add(nums[i]);
            helper(res, perm, nums);
            perm.remove(perm.size() - 1);
        }
    }
}
