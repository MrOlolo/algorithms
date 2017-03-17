package data;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import static org.junit.Assert.*;
/**
 * Created by Ololo on 17.03.2017.
 */
public class AlgTest {
    Random random = new Random();
    double[] delta = new double[10];

    @Test
    public void testSub(){
        for (int i = 0; i < 10; ++i) {
            delta[i] = random.nextInt(31)-15;
        }
        int firstNumber=0;
        int lastNumber=0;
        double maxSum = delta[0];
        double curSum= 0;
        int firstNumberQ=0;
        for (int i= 0; i <= delta.length-1; i++) {
            curSum+=delta[i];
            if(curSum>maxSum){
                maxSum = curSum;
                firstNumber=firstNumberQ;
                lastNumber = i;
            }
            if (curSum<0){
                firstNumberQ=i+1;
                curSum=0;
            }
        }
        SearchAlg.Case s;
        SearchAlg f=new SearchAlg();
        s=f.maxSubAr(delta,0,delta.length-1);
        //if (s.s==firstNumber&&s.e==lastNumber&&s.sum==maxSum){
        assertTrue(s.sum==maxSum);
        //System.out.println("MaxSubArray:");
        //System.out.println(Arrays.toString(delta));
        //System.out.println("CHECK Elements(first index=0):["+firstNumber+","+lastNumber+"], Max Sum="+maxSum);
        //System.out.println("Elements(first index=0):["+s.s+","+s.e+"], Max Sum="+s.sum);
    }
}
