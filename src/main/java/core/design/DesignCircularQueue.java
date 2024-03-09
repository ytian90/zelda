package core.design;

/**
 * LC 622. Design Circular Queue
 */
public class DesignCircularQueue {
    int[] a;
    int front = 0, rear = -1, len = 0;

    public DesignCircularQueue(int k) {
        this.a = new int[k];
    }

    public boolean enQueue(int value) {
        if (!isFull()) {
            rear = (rear + 1) % a.length;
            a[rear] = value;
            len++;
            return true;
        } else {
            return false;
        }
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % a.length;
            len--;
            return true;
        } else {
            return false;
        }
    }

    public int Front() {
        return isEmpty() ? -1 : a[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : a[rear];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == a.length;
    }
    // T: O(1)
    // S: O(N)
}
