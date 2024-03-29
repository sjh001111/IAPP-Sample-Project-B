import java.util.*;
/**
 * class Cinema 
 */
public class Cinema
{
    private final String NAME = "MyCinema";
    protected double balance = 100000.00;
    protected double profit = 0.0;
    Movies movies;
    Theatres theatres;
    Sessions sessions;
    
    public Cinema()
    {
        movies = new Movies();
        theatres = new Theatres();
        sessions = new Sessions();
        menu();
    }

    private void menu()
    {
        char action = readAction();
        switch (action)
        {
            case 'M': addMovie(); break;
            case 'T': addTheatre(); break;
            case 'S': addSession(); break;
            case 'L': sellTickets(); break;
            case 'H': hireTheatre(); break;
            case 'R': report(); break;
            case 'X': exit(); break;
            case '?': help(); break;
            default: error();
        }
    }

    private char readAction()
    {
        System.out.print("Please enter your choice (M, T, S, L, H, N, R, X, ?): ");
        return In.nextUpperChar();
    }

    private void addMovie()
    {
        System.out.println("Setup a Movie");
        movies.add();
        menu();
    }

    private void addTheatre()
    {
        System.out.println("Add a Theatre");
        theatres.add();
        menu();
    }

    private void addSession()
    {
        System.out.println("Add a Session");
        String name = In.readString("\tEnter Session Name: ");
        int movieId = In.readInt("\tEnter Movie id: ");
        Movie movie = movies.find(movieId);
        if(movie != null){
            int theatreId = In.readInt("\tEnter Theatre id: ");
            Theatre theatre = theatres.find(theatreId);
            if(theatre != null){
                int time = In.readInt("\tEnter Session Time - 0 for 9am, 1 for 12noon, 2 for 3pm or 3 for 6pm:  ");
                sessions.add(movie, theatre, name, time);
            }
            else
                System.out.println("\tTheatre  id is incorrect, session aborted ");
        }
        else
            System.out.println("\tMovie id is incorrect, session aborted ");
        menu();
    }

    private void sellTickets()
    {
        sessions.sellTickets();
        menu();
    }

    private void hireTheatre()
    { 
        System.out.println("Hire a Theatre");
        int theatreId = In.readInt("\tEnter Theatre id:  ");
        Theatre theatre = theatres.find(theatreId);
        if(theatre != null){
            int time = In.readInt("\tEnter Session Time - 0 for 9am, 1 for 12noon, 2 for 3pm or 3 for 6pm:   ");
            theatre.book(time);
        }
        else
            System.out.println("\tTheatre id is incorrect, hire aborted ");
        menu();
    }  

    private double income()
    {
        return sessions.income();
    }

    private double cost()
    {
        return sessions.cost();
    }

    private void profit()
    { 
        profit = income() - cost();
    }

    private double balance()
    { 
        return balance + profit;
    }

    private void report()
    {   
        System.out.println(movies.toString());
        System.out.println(theatres.toString());
        System.out.println(sessions.toString());
        profit();
        System.out.println(this.toString());
        menu();
    } 

    private void exit()
    {
        if (!confirm())
            menu();
        else
            System.out.println("Goodbye");
    }

    private boolean confirm()
    {
        System.out.print("Are you sure (y/n)?: ");
        return In.nextUpperChar() == 'Y';
    }

    private void help()
    {
        System.out.println("Welcome to TuneMe; enter");
        System.out.println("M for Add Movie");
        System.out.println("T for Add Theatre");
        System.out.println("S for Add Session");
        System.out.println("H for Hire Theatre");
        System.out.println("R for Cinema Report");
        System.out.println("X to exit");
        menu();
    }

    private void error()
    {
        System.out.println("No action found. Try again");
        menu();
    }

    private void show()
    {   
        System.out.println(toString()); 
    }                

    public String toString()
    {   String s = "Cinema:";
        s += " cost = $" + cost();
        s += " income = $" + income();
        s += " profit = $" + profit;
        s+= " balance = $" + balance();
        return s;   
    }

}