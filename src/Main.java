import java.io.IOException;
import java.text.ParseException;

public class Main {
    
    
    public static void main(String[] args) throws ParseException {

        FileParser firstFile = new FileParser();
        int checkStatus = 0;

        try{
            checkStatus = firstFile.lineReaderParse();

        }catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    //Efeitos de teste
        if(checkStatus == 200){
            System.out.println(firstFile.arrayRefVar.get(0));
            System.out.println(firstFile.arrayRefVar.size());
        }
        System.out.println("Tester2");
    }
}
