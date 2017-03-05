package data;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ololo on 04.03.2017.
 */
public class Main {
    public static void main(String[] args) {
       //double[] price={-5.0, 9.0, -4.0, 10.0, 11.0, 1.0, 10.0, 6.0, -13.0, 5.0};
        Random random = new Random();
        double[] price = new double[10];
        for (int i = 0; i < 10; ++i) {
           price[i] = random.nextInt(31)-15;
        }
        SearchAlg.Case s;
        SearchAlg f=new SearchAlg();
        s=f.maxSubAr(price,0,price.length-1);
        System.out.println("MaxSubArray:");
        System.out.println(Arrays.toString(price));
        System.out.println("Elements(first index=0):["+s.s+","+s.e+"], Max Sum="+s.sum);
    }

}
