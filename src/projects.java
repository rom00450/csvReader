// An implementation of a Training Record as an ArrayList

import java.util.*;

public class projects {
    private List<Entry> tr;

    public projects() {
        tr = new ArrayList<Entry>();
    } //constructor


    // add a record to the list
    public void addEntry(Entry e) {
        if (tr.contains(e)) {
            System.out.println("Could not add entry");
        } else {
            tr.add(e);
        }
    } // addClass

    public double profit(String type ){ //Method that calculates the total profit for all entries of a given type
        ListIterator<Entry> iter = tr.listIterator();
        double n = 0;

        while(iter.hasNext()){
            Entry current = iter.next();
            if(current.getType().equalsIgnoreCase(type)){
                n = (current.getPrice() - current.getCost() + n);
            }
        }

        return n;
    }


    public ArrayList<String> findType(String type) {    //Method that finds all entries of a given type
        ListIterator<Entry> iter = tr.listIterator();
        ArrayList<String> list = new ArrayList<>();
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getType().equalsIgnoreCase(type)) {
                list.add(current.getEntry());
            }
        }
        return list;
    }

    public ArrayList<String> findLocation (String location) {   //Method that finds all entries of a given location
        ListIterator<Entry> iter = tr.listIterator();
        ArrayList<String> list = new ArrayList<>();
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getLocation().equalsIgnoreCase(location)) {
                list.add(current.getEntry());
            }
        }
        return list;
    }

    public ArrayList<String> lowerPrice (String price) {    //Method that finds all entries with same or lower price
        ListIterator<Entry> iter = tr.listIterator();
        ArrayList<String> list = new ArrayList<>();
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getPrice() <= Double.valueOf(price)) {
                list.add(current.getEntry());
            }
        }
        return list;
    }




    public String lookupAllEntry ( int id, String n){   //Method to find a single entry based on id and name
        ListIterator<Entry> iter = tr.listIterator();
        String result = "No entries found";
        ArrayList<String> results = new ArrayList();
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().equalsIgnoreCase(n) && current.getID() == id) {
                results.add(current.getEntry());
            }
        }
        return results.toString();
    } // lookupEntry

    // Count the number of entries
    public int getNumberOfEntries () {
        return tr.size();
    }


    // Clear all entries
    public void clearAllEntries () {
        tr.clear();
    }

    public String removeEntry ( int id, String n){  //Method to remove an entry given an id and a name
        ListIterator<Entry> iter = tr.listIterator();
        String result = "Entry removed";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().equalsIgnoreCase(n) && current.getID() == id) {
                tr.remove(current);
            }
        }
        return result;
    }

}


