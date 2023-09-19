public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque ad =new ArrayDeque<>();
        for(int i=0;i<5;i++){
            ad.addFirst(i);
        }
        for(int i=5;i<8;i++){
            ad.addLast(i);
        }
        for(int i=0;i<2;i++){
            int a = (int) ad.removeFirst();
        }
        for(int i=0;i<2;i++){
            int a = (int) ad.removeLast();
        }

    }
}
