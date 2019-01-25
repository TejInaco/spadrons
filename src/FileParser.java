import java.io.*;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;


public class FileParser {
    //Dynamic Array to avoid having a strict size array, in Java we can't change is size
    public ArrayList<String> arrayRefVar = new ArrayList<String>();
    public FileReader filename = null;

    /**
     * default constructor
     * */
    public FileParser(){
        try {
            this.filename = new FileReader("input.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Check file existence
     * @param filename name of the file with strings
     * **/
    public FileParser(String filename){
        try {
            this.filename = new FileReader(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * line by line file reader
     * @return 200 is OK
     */
    public int lineReaderParse() throws IOException, ParseException {
            String line;
            FileReader frd = this.filename;
            BufferedReader brd = new BufferedReader(frd);

        try {
            while ((line = brd.readLine()) != null) {
                this.arrayRefVar.add(line);
            }

        }catch(IOException e){
            e.printStackTrace();
        //finally block allows you to run any cleanup-type statements
        // that you want to execute, no matter what happens in the protected code.
        }finally {
            try {
                brd.close();
                frd.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }

        }
        return 200;
    }

}
