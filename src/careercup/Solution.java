package careercup;


public class Solution {
    public void integerDivision(int num, int den){
        int q=0,rem=0;
        while(num>=den){
            num-=den;
            q++;
        }
        rem=num;
        System.out.println("Quotient "+q+" Remainder "+rem);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.integerDivision(73, 9);

    }

}
