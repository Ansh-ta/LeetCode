class Solution {
    public double myPow(double x, int n) {
        long dummy=n;
        double ans=1.0;
        if(n<0) dummy=dummy*-1;
        while(dummy>0){
            if(dummy%2==0)
            {
                x=x*x;
                dummy=dummy/2;
            }
            else{
                ans=ans*x;
                dummy-=1;
            }
        }
        if(n<0) ans=(double)(1.0)/(double)(ans);
        return ans;
    }
}