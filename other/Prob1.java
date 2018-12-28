import java.util.List;
import java.util.*;
import java.util.Random;

/**
 * PROBLEM DEFENITION FROM: 
 * https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/sniper-shooting/
 * (2018-12-27)
 * 
 * There are N frustrated coders standing in a circle with a gun in their
 * hands. Each coder has a skill value S[ i ] and he can only kill those 
 * coders that have strictly less skill than him. One more thing, all the
 * guns have only 1 bullet. This roulette can take place in any random 
 * order. Fortunately, you have the time stone (haaan wo harre wala) and
 * you can see all possible outcomes of this scenario. Find the outcome where 
 * the total sum of the remaining coder's skill is minimum. Print this sum.
 */

class Prob1{

    public List<Coder> coders = new ArrayList<>();
    public Prob1(int n){
        int i = 0;
        Random r = new Random();
        // Create a list of length n with coders of random skill.
        while(i < n){
            i++;
            coders.add(new Coder(r.nextInt(1000)+1));
        }
    }

    public List<Coder> mergeSort(List<Coder> cs){
        if(cs.size() < 2){
            return cs;
        }

        List<Coder> left = mergeSort(cs.subList(0, cs.size()/2));
        List<Coder> right = mergeSort(cs.subList(cs.size()/2, cs.size()));
        return merge(left, right);
    }

    public List<Coder> merge(List<Coder> left, List<Coder> right){
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }

        List<Coder> result = new ArrayList<>();
        int l = 0;
        int r = 0;
        while(l < left.size() && r < right.size()){
            if(left.get(l).skill < right.get(r).skill){
                result.add(left.get(l));
                l++;
            }
            else{
                result.add(right.get(r));
                r++;
            }
        }
        while(l < left.size()){
            result.add(left.get(l));
            l++;
        }
        while(r < right.size()){
            result.add(right.get(r));
            r++;
        }
        System.out.println(codersToString(result));
        return result;
    }

    public Prob1(List<Integer> cs){
        for(int i : cs){
            coders.add(new Coder(i));
        }
    }

    public void kill(int i){
        coders.remove(i);
    }

    public int play(){
        coders = mergeSort(coders);
        int i = 1;
        while(i < coders.size()){
            int j = 0;
            // Find coder with skill strictly less than current coder
            while(coders.get(j).skill == coders.get(i).skill && j < i){j++;}
            if(j >= 0 && j < i){
                coders.remove(j);   
                i--;             
            }
            i++;
        }
        int sum = 0;
        for(Coder c : coders){
            System.out.println(c.skill);
            sum += c.skill;
        }
        return sum; 
    }

    private class Coder{

        public int skill;

        public Coder(int skill){
            this.skill = skill;
        }
    }
 
    public String codersToString(List<Coder> cs){
        String result = "";
        for(Coder c : cs){
            result += c.skill + " ";
        }
        return result;

    }

    public static void main(String[] args){
        List<Integer> is = new ArrayList<>();
        // 1 7 2 2 4 4
        is.add(1);
        is.add(7);
        is.add(2);
        is.add(2);
        is.add(4);
        is.add(4);
        Prob1 x = new Prob1(is);
        System.out.println(x.play());
    }
}