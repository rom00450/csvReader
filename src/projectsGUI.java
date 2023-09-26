// GUI and main program for the projects csv file

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class projectsGUI extends JFrame implements ActionListener {

    private JTextField ID = new JTextField(4);
    private JTextField name = new JTextField(5);
    private JTextField type = new JTextField(5);
    private JTextField date = new JTextField(5);
    private JTextField location = new JTextField(5);
    private JTextField cost = new JTextField(4);
    private JTextField price = new JTextField(4);
    //private JTextField size = new JTextField(4);
    private String[] sizes = {"small", "Medium", "large"};
    private JComboBox size = new JComboBox(sizes);
    private JTextField duration = new JTextField(4);
    private JTextField durationUnits = new JTextField(4);

    private JTextField network = new JTextField(4);
    private JTextField playwright = new JTextField(4);
    private JTextField genre = new JTextField(4);
    private JTextField format = new JTextField(4);

    private JLabel labid = new JLabel(" ID:");
    private JLabel labn = new JLabel(" Name:");
    private JLabel labt = new JLabel(" Type:");
    private JLabel labdt = new JLabel(" Date:");
    private JLabel labl = new JLabel(" Location:");
    private JLabel labc = new JLabel(" Cost:");
    private JLabel labp = new JLabel(" Price:");
    private JLabel labs = new JLabel(" Venue Size:");
    private JLabel labd = new JLabel(" Duration:");
    private JLabel labdu = new JLabel(" Duration Units:");

    private JLabel labNetwork = new JLabel(" Network:");
    private JLabel labPlaywright = new JLabel(" Playwright:");
    private JLabel labGenre = new JLabel(" Genre:");
    private JLabel labFormat = new JLabel(" Format:");


    private JButton addR = new JButton("Add");
    private JButton search = new JButton("Search by id and name");
    private JButton summary = new JButton("Summary");
    private JButton readCSV = new JButton ("Read CSV file");
    private JButton findType = new JButton("Search all by type");
    private JButton findLocations = new JButton("Search all given a location");
    private JButton findPrice = new JButton ("Search all with lower price");


    private JButton remove = new JButton("Remove");

    private projects myProjects = new projects();

    private JTextArea outputArea = new JTextArea(5, 50);


    public static void main(String[] args) throws IOException {
        projectsGUI applic = new projectsGUI();
    } // main

    // set up the GUI
    public projectsGUI() {
        super("Project Records");
        setLayout(new FlowLayout());
        add(labid);
        add(ID);
        ID.setEditable(true);
        add(labn);
        add(name);
        name.setEditable(true);
        add(labt);
        add(type);
        type.setEditable(true);
        add(labl);
        add(location);
        location.setEditable(true);
        add(labdt);
        add(date);
        date.setEditable(true);
        add(labc);
        add(cost);
        cost.setEditable(true);
        add(labp);
        add(price);
        price.setEditable(true);
        add(labs);
        add(size);
        size.addActionListener(this);
        add(labd);
        add(duration);
        duration.setEditable(true);
        add(labdu);
        add(durationUnits);
        durationUnits.setEditable(true);
        add(labFormat);
        add(format);
        format.setEditable(true);
        add(labGenre);
        add(genre);
        genre.setEditable(true);
        add(labNetwork);
        add(network);
        network.setEditable(true);
        add(labPlaywright);
        add(playwright);
        playwright.setEditable(true);

        add(addR);
        addR.addActionListener(this);
        add(summary);
        summary.addActionListener(this);
        add(search);
        search.addActionListener(this);
        add(remove);
        remove.addActionListener(this);
        add(findType);
        findType.addActionListener(this);
        add(findLocations);
        findLocations.addActionListener(this);
        add(findPrice);
        findPrice.addActionListener(this);


        //add(outputArea);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);   //creates scrollable output area
        add(scrollPane);
        outputArea.setEditable(false);
        add(readCSV);
        readCSV.addActionListener(this);

        setSize(720, 350);
        setVisible(true);
        blankDisplay();


    } // constructor

    // listen for and respond to GUI events
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == summary) {
            message = createSummary();

        }
        if (event.getSource() == search) {
            message = dateEntry();
        }

        if (event.getSource() == remove) {
            deleteEntry();

        }
        if(event.getSource()==readCSV){
            readCSVFile();
        }
        if(event.getSource()==findType){
            message = findAllSameType();
        }
        if(event.getSource()==findLocations){
            message = findAllSameLocation();
        }
        if(event.getSource()==findPrice){
            message = findAllLowerPrice();
        }

        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String findAllSameType() {   //method to find all projects with the same type and print it out in output area
        String message = "";
        if (type.getText().isEmpty()) {
            message = "Please input something in the 'Type' box";
        } else {
            String typeToSearch = type.getText();
            ArrayList<String> matchingEntries = myProjects.findType(typeToSearch);
            StringBuilder sb = new StringBuilder();
            for (String entry : matchingEntries) {
                sb.append(entry).append("\n");
            }
            message = sb.toString();
        }
        return message;
    }

    public String findAllSameLocation(){    //method to find all projects with the same location and print it out in output area
        String message = "";
        if (location.getText().isEmpty()) {
            message = "Please input something in the 'Location' box";
        } else {
            String locationToSearch = location.getText();
            ArrayList<String> matchingEntries = myProjects.findLocation(locationToSearch);
            StringBuilder sb = new StringBuilder();
            for (String entry : matchingEntries) {
                sb.append(entry).append("\n");
            }
            message = sb.toString();
        }

        return message;
    }

    public String findAllLowerPrice(){  //method to find all projects with the same or lower price and print it out in output area
        String message = "";
        if (price.getText().isEmpty()) {
            message = "Please input something in the 'Price' box";
        } else {
            String priceToSearch = price.getText();
            ArrayList<String> matchingEntries = myProjects.lowerPrice(priceToSearch);
            StringBuilder sb = new StringBuilder();
            for (String entry : matchingEntries) {
                sb.append(entry).append("\n");
            }
            message = sb.toString();
        }
        return message;
    }


    public void readCSVFile() { //Method to read the csv file given a filePath directory (change to use)
        CSVReader reader = null;
        try {
            reader = new CSVReader("/Users/****/Desktop/the_kilted_haggis_productions_projects.csv");
            myProjects = reader.getCsvProjects();
            System.out.println("CSV has been read");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String addEntry(String what) {   //Method to add entries to system
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        String message = "Record added\n";
        System.out.println("Adding " + what + " entry to the records");

        int id = Integer.parseInt(ID.getText());    //Gets all values from input boxes
        String n = name.getText();
        String t = type.getText();
        String l = location.getText();
        double c = Double.parseDouble(cost.getText());
        double p = Double.parseDouble(price.getText());
        String s = (String) size.getSelectedItem();
        int d = Integer.parseInt(duration.getText());
        String du = durationUnits.getText();

        String nt = network.getText();
        String pw = playwright.getText();
        String g = genre.getText();
        String f = format.getText();

        try {
            Date dt = dateFormat.parse(date.getText());
            if (!nt.isEmpty()) {
                tvProject e = new tvProject(id, n, t, dt, l, c, p, s, d, du, nt);
                System.out.println("Network project added");
                myProjects.addEntry(e);
            } else if (!pw.isEmpty()) {
                theatreProject e = new theatreProject(id, n, t, dt, l, c, p, s, d, du, pw);
                System.out.println("Playwright project added");
                myProjects.addEntry(e);
            } else if (!g.isEmpty()) {
                musicProject e = new musicProject(id, n, t, dt, l, c, p, s, d, du, g);
                System.out.println("Genre project added");
                myProjects.addEntry(e);
            } else if (!f.isEmpty()) {
                filmProject e = new filmProject(id, n, t, dt, l, c, p, s, d, du, f);
                System.out.println("Format project added");
                myProjects.addEntry(e);
            } else {
                Entry e = new Entry(id, n, t, dt, l, c, p, s, d, du);
                System.out.println("Generic project added");
                myProjects.addEntry(e);
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Format should be " + dateFormat);
            message = "Could not add entry";
        }
        return message;
    }

    public String deleteEntry() {   //Method to delete entry if needed (given id and name)
        int id = Integer.parseInt(ID.getText());
        String n = name.getText();
        outputArea.setText("looking for record to delete...");
        String message = myProjects.removeEntry(id, n);
        return message;
    }


    public String createSummary() { //Method that creates a summary about projects
        System.out.println("Creating a summary of all projects...");
        double filmProfit = myProjects.profit("Film");
        double tvProfit = myProjects.profit("TV");
        double musicProfit = myProjects.profit("Music");
        double theatreProfit = myProjects.profit("Theater");

        String filmProfitFormatted = String.format("%.2f", filmProfit );
        String tvProfitFormatted = String.format("%.2f", tvProfit);
        String musicProfitFormatted = String.format("%.2f", musicProfit);
        String theatreProfitFormatted = String.format("%.2f", theatreProfit);
        double totalProfit = filmProfit+tvProfit+musicProfit+theatreProfit;
        String formattedProfit = String.format("%.2f", totalProfit);

        String message = "The system has " + myProjects.getNumberOfEntries() + " entries. The overall profit for all entries is: " +
                formattedProfit + ". \nBreaking down the profits, the Films had a total profit of: " + filmProfitFormatted
                + " \nTV had a total profit of: " + tvProfitFormatted + " \nMusic projects had a total profit of: " + musicProfitFormatted
                + " \nand Theatre had a total profit of: " + theatreProfitFormatted;
        return message;

    }


    public String dateEntry(){  //Method that looks for a record in project given id and name
        //System.out.println("Not implemented yet...");
        int id = Integer.parseInt(ID.getText());
        String n = name.getText();
        outputArea.setText("looking up all records...");
        String message = myProjects.lookupAllEntry(id,n);
        return message;
    }

    public void blankDisplay() {    //sets display boxes to empty
        ID.setText("");
        name.setText("");
        type.setText("");
        date.setText("");
        location.setText("");
        cost.setText("");
        price.setText("");
        //size.set;
        duration.setText("");
        durationUnits.setText("");
        network.setText("");
        genre.setText("");
        playwright.setText("");
        format.setText("");



    }// blankDisplay

} // TrainingRecordGUI

