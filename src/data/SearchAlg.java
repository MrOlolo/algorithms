package data;

/**
 * Created by Ololo on 04.03.2017.
 */
public class SearchAlg {
    public static class Case{
        double sum;
        int s,e;
        public Case(double sum, int s, int e){
            this.sum=sum;
            this.s=s;
            this.e=e;
        }
    }
    Case right,cent,left;
    private int center;
    //private double delta[];

    private Case maxSubAr(double[] delta, int first,int last){
        int firstNumber=first;
        int lastNumber=first;
        double maxSum = delta[0];
        double curSum= 0;
        int firstNumberQ=first;
        for (int i= first; i <= last; i++) {
            curSum+=delta[i];
            if(curSum>maxSum){
                maxSum = curSum;
                firstNumber=firstNumberQ;
                lastNumber = i;
            }
            else if (curSum<0){
                firstNumberQ=i+1;
                curSum=0;
            }
        }
        return new Case(maxSum,firstNumber,lastNumber);
    }

    private Case maxCentSubAr(double[] delta, int first, int center, int last){
        int firstNumber=center-1;
        double maxLSum = delta[center-1];
        double curSum= 0;
        int firstNumberQ=center-1;
        for (int i= center-1; i >=first ; i--) {
            curSum+=delta[i];
            if(curSum>maxLSum){
                maxLSum = curSum;
                firstNumber=i;
            }
        }
        int lastNumber=center;
        curSum= 0;
        double maxRSum = delta[center];
        for (int i= center; i <= last; i++) {
            curSum+=delta[i];
            if(curSum>maxRSum){
                maxRSum = curSum;
                lastNumber = i;
            }
        }
        return new Case(maxLSum+maxRSum,firstNumber,lastNumber);
    }

    public Case SearchAlg(double[] delta){
        center =(int) Math.floor((delta.length+1)/2);
        //delta=new double[price.length-1];
       // for ( int i =0;i<price.length-1 ;i++) {
       //     delta[i] = price[i + 1] - price[i];
      //  }
       // Case right,cent,left;
        left=maxSubAr(delta,0,center-1);
        right=maxSubAr(delta,center,delta.length-1);
        cent=maxCentSubAr(delta,left.s,center,right.e);
        if(left.sum>=cent.sum&&left.sum>=right.sum){
            return left;
        } else if (cent.sum>right.sum&&cent.sum>left.sum){
            return cent;
        } else {
            return right;
        }
    }
}

