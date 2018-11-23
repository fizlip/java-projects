public class Letter{
    private int order;
    private String capital;
    private String lower;

    public Letter(int order, String capital, String lower){
        this.order = order;
        this.capital = capital;
        this.lower = lower;
    }

    public int getOrder(){
        return order;
    }

    public String getCapital(){
        return capital;
    }

    public String getLower(){
        return lower;
    }

    // Compare the orders of two letters
    public int compare(Letter x){
        if(this.order > x.order){
            return 1;
        }
        if(this.order == x.order){
            return 0;
        }
        return -1;
    }

}