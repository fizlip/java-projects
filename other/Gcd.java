class Gcd{

    public static void main(String[] args){
        System.out.println(gcd(101, 100));
    }

    /**
     * Find the greatest common denominator between two numbers by 
     * continously using the fact that every number a can be written
     * as a = qb + r, then using the same algorithm on b and so on until
     * the remainder is 0.
     */
    public static int gcd(int a, int b){
        // Division algorithm
        int max = (a > b) ? a : b;
        int min = (a <= b) ? a : b;
        if(max%min == 0){
            return min;
        }
        else{
            return gcd(min, max%min);
        }
    }

}