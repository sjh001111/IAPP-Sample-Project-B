public class Theatres extends Records{
    public void add(){
        String name = In.readString("\tEnter Theatre name : ");
        int gold = In.readInt("\tEnter number of Gold Class Seats : ");
        int regular = In.readInt("\tEnter number of Regular Seats  : ");
        records.add(new Theatre(++id, name, gold, regular));
    }

    public Theatre find(int id){
        return (Theatre) super.find(id);
    }
    
    public String toString(){
        String result = "";
        for(Record theatre : records)
            result += theatre.toString() + "\n";
        return result;
    }
}