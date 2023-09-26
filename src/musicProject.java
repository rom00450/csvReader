import java.util.Date;


public class musicProject extends Entry{
    private String genre;

    //Method to create an Entry of type musicProject
    public musicProject(int id, String n, String t, Date dt, String l, double c, double p, String s, int d, String du, String g) {
        super(id,n,t,dt,l,c,p,s,d,du);
        this.genre = g;
    }

    public String getGenre(){
        return genre;
    }

    //Method to get an Entry in string form
    public String getEntry () {
        String result = "Project ID: "+getID() +", Name: "+ getName()+", Type: " + getType() + ", Location: "
                +getLocation()+", Cost: "+getCost()+", Price: "+ getPrice() + ", Size: "
                +getSize()+", Duration: "+getDuration()+", Units: " +getDurationUnits()+ ", On Date: " + getDate() +", Genre: "+getGenre()+"\n";
        return result;
    } //getMusicProject
}
