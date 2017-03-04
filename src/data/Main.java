package data;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ololo on 04.03.2017.
 */
public class Main {
    public static void main(String[] args) {
       // double[] price={1,11, 7, 6, 10};
        double[] price = new double[10];
        Random random = new Random();

        for (int i = 0; i < 10; ++i) {
           price[i] = random.nextInt(31)-15;
        }
        System.out.println(Arrays.toString(price));
        SearchAlg.Case s;
        SearchAlg f=new SearchAlg();
        s=f.SearchAlg(price);
        System.out.println("MaxSubArray(first index=0):["+s.s+","+s.e+"], Max Sum="+s.sum);
    }

}
