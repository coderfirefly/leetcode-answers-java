import java.util.LinkedList;

/**
 * <a href=https://leetcode.cn/problems/design-circular-deque>641. 设计循环双端队列</a>
 * @Author phoebe
 * @Date 2023/6/28
 */
public class Leetcode_641_designCircularDeque {

    class MyCircularDeque {
        private LinkedList<Integer> list;
        private int capacity;

        public MyCircularDeque(int k) {
            list = new LinkedList<>();
            capacity = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            list.addFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            list.add(value);
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            list.removeFirst();
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            list.removeLast();
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return list.getFirst();
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return list.getLast();
        }

        public boolean isEmpty() {
            return list.size() == 0;

        }

        public boolean isFull() {
            return list.size() == capacity;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
