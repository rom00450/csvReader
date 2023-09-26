import java.util.Date;

public class theatreProject extends Entry{
    private String playwright;

    //Method to create an Entry of type theatreProject
    public theatreProject(int id, String n, String t, Date dt, String l, double c, double p, String s, int d, String du, String pw) {
        super(id,n,t,dt,l,c,p,s,d,du);
        this.playwright = pw;
    }

    public String getPlaywright(){
        return playwright;
    }

    //Method to get an Entry in string form
    public String getEntry () {
        String result = "Project ID: "+getID() +", Name: "+ getName()+", Type: " + getType() + ", Location: "
                +getLocation()+", Cost: "+getCost()+", Price: "+ getPrice() + ", Size: "
                +getSize()+", Duration: "+getDuration()+", Units: " +getDurationUnits()+ ", On Date: " + getDate() +", Playwright: "+getPlaywright()+"\n";
        return result;
    } //getTheatreProject
}
