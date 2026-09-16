class Solution {
    public boolean isPerfectSquare(int num) {
        long l=1,r=num;

        while(l<=r){
            long m=(l+r)/2;
            
            if(m*m==num)
                return true;
            else if(m*m<num)
                l=m+1;
            else
                r=m-1;
        }

        return false;
    }
}