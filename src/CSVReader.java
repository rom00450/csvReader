import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CSVReader {

    private projects csvProjects = new projects();

    public CSVReader(String filePath) throws IOException {  //Method to read the CSV file
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
            String line;
            boolean firstLine = true;
            while ((line = bufferedReader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = new String[14];
                values = line.split(",");
                int id = Integer.parseInt(values[0]);
                String n = values[1];
                String t = values[2];
                String l = values[4];
                double c = Double.parseDouble(values[5]);
                double p = Double.parseDouble(values[6]);
                String s = values[7];
                int d = Integer.parseInt(values[8]);
                String du = values[9];


                try {
                    Date dt = dateFormat.parse(values[3]);
                    if(values[10] != null){
                        String nt = values[10];
                        tvProject e = new tvProject(id, n, t, dt, l, c, p, s, d, du, nt);
                        csvProjects.addEntry(e);
                    }
                    else if(values[11] != null){
                        String pw = values[11];
                        theatreProject e = new theatreProject(id, n, t, dt, l, c, p, s, d, du, pw);
                        csvProjects.addEntry(e);
                    }
                    else if(values[12] != null){
                        String g = values[12];
                        musicProject e = new musicProject(id, n, t, dt, l, c, p, s, d, du, g);
                        csvProjects.addEntry(e);
                    }
                    else if(values[13] != null){
                        String f = values[13];
                        filmProject e = new filmProject(id, n, t, dt, l, c, p, s, d, du, f);
                        csvProjects.addEntry(e);
                    }

                    else {
                        Entry e = new Entry(id, n, t, dt, l, c, p, s, d, du);
                        csvProjects.addEntry(e);
                    }
                } catch (ParseException e) {
                    System.out.println("Invalid date format. Format should be " + dateFormat);
                }
            }
        }
    }

    public projects getCsvProjects() {  //getter to retrieve the newly added projects
        return csvProjects;
    }
}
