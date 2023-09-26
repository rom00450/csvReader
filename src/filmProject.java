import java.util.Date;


public class filmProject extends Entry{
    private String format;

    //Method to create an Entry of type filmProject
    public filmProject(int id, String n, String t, Date dt, String l, double c, double p, String s, int d, String du, String f) {
        super(id,n,t,dt,l,c,p,s,d,du);
        this.format = f;
    }

    public String getFormat(){
        return format;
    }

    //Method to get an Entry in string form
    public String getEntry () {
        String result = "Project ID: "+getID() +", Name: "+ getName()+", Type: " + getType() + ", Location: "
                +getLocation()+", Cost: "+getCost()+", Price: "+ getPrice() + ", Size: "
                +getSize()+", Duration: "+getDuration()+", Units: " +getDurationUnits()+ ", On Date: " + getDate() +", Format: "+getFormat()+"\n";
        return result;
    } //getFilmProject

}
