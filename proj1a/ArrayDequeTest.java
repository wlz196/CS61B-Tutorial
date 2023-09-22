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
    @Test
    public void add0(){
        ArrayDeque ad =new ArrayDeque<>();
        for(int i=0;i<7;i++){
            ad.addLast(0);
        }
        System.out.println(ad.get(0));
    }
    @Test
    public void quyu(){
        ArrayDeque ad =new ArrayDeque<>();
        ad.size();
        ad.addFirst(1);
    }
    @Test
    public void testGet(){
        ArrayDeque ad =new ArrayDeque<>();
        ad.addLast(0);
        ad.addLast(1);
        ad.addFirst(2);
        ad.addFirst(3);
        ad.removeFirst();
        ad.addLast(5);
        ad.addFirst(6);
        ad.removeFirst();
        ad.removeLast();
        ad.removeLast();
        ad.addLast(10);
        System.out.println(ad.get(0));

    }
    @Test
    public void TestChangeSize(){
        ArrayDeque ad =new ArrayDeque<>();
        for(int i=0;i<6;i++){
            ad.addFirst(i);
        }
        for(int i=6;i<13;i++){
            ad.addLast(i);
        }
        ad.addFirst(12);
        for(int i=0;i<12;i++){
            ad.removeFirst();
        }
    }
    @Test
    public void Testaddre(){
        ArrayDeque ad =new ArrayDeque<>();
        for(int i=0;i<8;i++) {
            ad.addLast(i);
        }
        System.out.println(ad.removeFirst());
        System.out.println(ad.removeLast());
    }
}
