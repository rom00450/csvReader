import java.util.Date;

public class tvProject extends Entry{
    private String network;

    //Method to create an Entry of type TVProject
    public tvProject(int id, String n, String t, Date dt,String l, double c, double p, String s, int d, String du, String nt) {
        super(id,n,t,dt,l,c,p,s,d,du);
        this.network = nt;
    }

    public String getNetwork(){
        return network;
    }

    //Method to get an Entry in string form
    public String getEntry () {
        String result = "Project ID: "+getID() +", Name: "+ getName()+", Type: " + getType() + ", Location: "
                +getLocation()+", Cost: "+getCost()+", Price: "+ getPrice() + ", Size: "
                +getSize()+", Duration: "+getDuration()+", Units: " +getDurationUnits()+ ", On Date: " + getDate() +", Network: "+getNetwork()+"\n";
        return result;
    } //getTvProject

}
