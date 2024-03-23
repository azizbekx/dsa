package grokking.coding_pattern.greedy_techniques;

class Pair{
    int cost1;
    int cost2;
    int diff1Over2;
    int index;

    public Pair(int cost1, int cost2, int diff1Over2, int index){
        this.cost1 = cost1;
        this.cost2 = cost2;
        this.diff1Over2 = diff1Over2;
        this.index= index;
    }
    public int getDiff1Over2(){
        return diff1Over2;
    }

}