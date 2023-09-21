import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void Testaddandget(){
        ArrayDeque ad =new ArrayDeque<>();
        for(int i=0;i<7;i++){
            ad.addLast(0);
        }
    }
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
            ad.addFirst(a*a);
        }
        for(int i=0;i<2;i++){
            int a = (int) ad.removeLast();
            ad.addLast(a*a);
        }

    }
}
