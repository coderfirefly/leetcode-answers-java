import org.junit.Assert;

import java.util.Arrays;

/**
 * <a href=https://leetcode.cn/problems/design-skiplist>1206. 设计跳表</a>
 *
 * @Author phoebe
 * @Date 2023/6/21
 */
public class Leetcode_1206_designSkiplist {
    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        Assert.assertFalse(skiplist.search(0));
//        skiplist.printAll();

        skiplist.add(4);
        Assert.assertTrue(skiplist.search(1));
        Assert.assertFalse(skiplist.erase(0));
        Assert.assertTrue(skiplist.erase(1));
        Assert.assertFalse(skiplist.search(1));
    }

}

class Skiplist {
    // 表头结点 dummy
    private SkiplistNode head;
    // 允许最大的层次数
    private final int MAX_LEVEL = 32;
    private final double RANDOM_P = 0.5f;
    // 当前的层次数
    private int level;

    public Skiplist() {
        this.head = new SkiplistNode(-1, MAX_LEVEL);
        this.level = 0;
    }

    public boolean search(int target) {
        SkiplistNode cur = this.head;
        for (int i = this.level - 1; i >= 0; i--) {
            while (cur.forwards[i] != null && cur.forwards[i].val < target) {
                cur = cur.forwards[i];
            }
        }
        return cur.forwards[0] != null && cur.forwards[0].val == target;
    }

    public void add(int num) {
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
        // 可能是第一个节点
        Arrays.fill(update, head);
        SkiplistNode cur = this.head;
        for (int i = this.level - 1; i >= 0; i--) {
            while (cur.forwards[i] != null && cur.forwards[i].val < num) {
                cur = cur.forwards[i];
            }
            update[i] = cur;
        }
        int newLevel = randomLevel();
        System.out.println(num + "," + newLevel);
        SkiplistNode newNode = new SkiplistNode(num, newLevel);
        for (int i = 0; i < newLevel; i++) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }
        this.level = Math.max(this.level, newLevel);
    }

    public boolean erase(int num) {
        SkiplistNode[] update = new SkiplistNode[MAX_LEVEL];
        SkiplistNode cur = this.head;
        for (int i = this.level - 1; i >= 0; i--) {
            while (cur.forwards[i] != null && cur.forwards[i].val < num) {
                cur = cur.forwards[i];
            }
            update[i] = cur;
        }
        cur = cur.forwards[0];
        // 不存在
        if (cur == null || cur.val != num) {
            return false;
        }
        for (int i = 0; i < cur.forwards.length; i++) {
            update[i].forwards[i] = cur.forwards[i];
        }
        return true;
    }

    private int randomLevel() {
        int curLevel = 1;
        while (Math.random() < RANDOM_P && curLevel < MAX_LEVEL) {
            curLevel++;
        }
        return curLevel;
    }

    public void printAll() {
        SkiplistNode p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0].val + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    class SkiplistNode {
        int val;
        SkiplistNode[] forwards;

        SkiplistNode(int val, int leval) {
            this.val = val;
            this.forwards = new SkiplistNode[leval];
        }
    }
}
