public class test {
    public static void main(String[] args) {
        PQ_heap<Integer> h = new PQ_heap<>();
        h.enqueue(6);
        h.enqueue(13);
        h.enqueue(5);
        h.enqueue(12);
        h.enqueue(17);
        h.enqueue(10);
        h.enqueue(16);
        h.printList();
    }
}
