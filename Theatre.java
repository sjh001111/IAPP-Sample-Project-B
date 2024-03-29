public class Theatre extends Record{
    private int gold;
    private int regular;
    private boolean vacant[] = {true, true, true, true};

    public Theatre(int id, String name, int gold, int regular){
        super(id, name);
        this.gold = gold;
        this.regular = regular;
    }

    public void setBooked(int time){
        vacant[time] = false;
    }   

    public int goldSeats(){
        return gold;
    }

    public int regularSeats(){
        return regular;
    }

    public boolean vacant(int time){
        return vacant[time];
    }

    public void book(int time){
        if(vacant(time)){
            double amount = In.readDouble("Hire amount: ");
            System.out.println("Theatre hired");
        }
        else
            System.out.println("Theatre not available for the selected time, hire aborted ");
    }

    public String toString(){
        return "Theatre: " + id + " " + name;
    }
}