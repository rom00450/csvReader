import java.util.Date;

public class Entry {

    private int ID;
    private String name;
    private String type;
    private Date date;
    private String location;
    private double cost;
    private double price;
    private String size;
    private int duration;
    private String durationUnits;

    //Method to create a generic entry
    public Entry (int id, String n, String t, Date dt, String l, double c, double p, String s, int d, String du) {
        ID = id;
        name = n;
        type = t;
        date = dt;
        location = l;
        cost = c;
        price = p;
        size = s;
        duration = d;
        durationUnits = du;

    } //constructor

    public int getID () { return ID; } //getID
    public String getName () {
        return name;
    } //getName
    public String getType () { return type; } //getType
    public Date getDate () { return date; } //getDate
    public String getLocation () { return location; } //getLocation
    public double getCost () { return cost; } //getCost
    public double getPrice () { return price; } //getPrice
    public String getSize () { return size; } //getSize
    public int getDuration () { return duration; } //getDuration
    public String getDurationUnits () { return durationUnits; } //getDurationUnits



    //Method to get an Entry in string form
    public String getEntry () {
        String result = "Project ID: "+getID() +", Name: "+ getName()+", Type: " + getType() + ", Location: "
                +getLocation()+", Cost: "+getCost()+", Price: "+ getPrice() + ", Size: "
                +getSize()+", Duration: "+getDuration()+", Units: " +getDurationUnits()+ ", On Date: " + getDate() +"\n";
        return result;
    } //getEntry

}
