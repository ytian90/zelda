package core.design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 346. Moving Average from Data Stream
 */
public class MovingAverageFromDataStream {
    Queue<Integer> list;
    double sum;
    int size;

    public MovingAverageFromDataStream(int size) {
        this.list = new LinkedList();
        this.sum = 0;
        this.size = size;
    }

    public double next(int val) {
        if (list.size() >= size) {
            sum -= list.poll();
        }
        list.add(val);
        sum += val;
        return sum / list.size();
    }
    // T: O(1)
    // S: O(N)

    public static void main(String[] args) {
        MovingAverageFromDataStream obj = new MovingAverageFromDataStream(3);
        System.out.println(obj.next(1));
        System.out.println(obj.next(10));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));
    }

}
