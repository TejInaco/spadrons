import java.io.*;
import java.io.FileReader;
import java.text.ParseException;


public class PtextDealer {
    public String[] arrayRefVar;
    public FileReader filename = null;

    public PtextDealer(){

    }
    public PtextDealer(String filename){
        try {
            this.filename = new FileReader("input.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.arrayRefVar = {};
    }

    public int processFile(){
        try {
            char [] a = new char[50];
            filename.read(a);   // reads the content to the array
            for(char c : a)
                System.out.print(c);   // prints the characters one by one
        } catch (IOException e) {
            e.printStackTrace();
            //finally block allows you to run any cleanup-type statements
            // that you want to execute, no matter what happens in the protected code.
        }finally {
            try {
                filename.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //Status OK;
        return 200;
    }

    /**
     * line by line file reader
     * @param
     * @return
     */
    public void lineReaderParse(final int numberOfFiles) throws IOException, ParseException {
            String line;

            FileReader frd = this.filename;
            BufferedReader brd = new BufferedReader(frd);

            while ((line=brd.readLine())!=null)

            brd.close();
            frd.close();

    }

    public final void doSomethingWithLine(String line) throws ParseException {
        // Example of what to do for each line
        String[] fields = line.split(";");
        Date dt = fmt.parse(fields[0]);
        double d = Double.parseDouble(fields[1]);
        int t = Integer.parseInt(fields[2]);
        if (fields[3].equals("overrun"))
            overrunCount++;
    }
}
