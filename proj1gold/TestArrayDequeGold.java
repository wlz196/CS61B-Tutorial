import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Random;

public class TestArrayDequeGold {
    @Test
    public void Test(){
        int i=0;
        StudentArrayDeque sd = new StudentArrayDeque<>();
        ArrayDequeSolution ad = new ArrayDequeSolution();
        while(true){
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if(numberBetweenZeroAndOne<0.25){
                sd.addFirst(i);
                ad.addFirst(i);
                i++;
            }else if(numberBetweenZeroAndOne<0.5){
                sd.addLast(i);
                ad.addLast(i);
                i++;
            }else if(numberBetweenZeroAndOne<0.75){
                if(ad.isEmpty()|| sd.isEmpty()) continue;
                Integer tmp1 = (Integer) sd.removeFirst();
                Integer tmp2 = (Integer) ad.removeFirst();
                if(tmp1 != tmp2) {
                    assertEquals("failed",tmp2,tmp1);
                    break;
                }
            }else{
                if(ad.isEmpty()|| sd.isEmpty()) continue;
                Integer tmp1 = (Integer) sd.removeLast();
                Integer tmp2 = (Integer) ad.removeLast();
                if(tmp1 != tmp2) {
                    assertEquals("failed",tmp2,tmp1);
                    break;
                }
            }
        }
    }
}
