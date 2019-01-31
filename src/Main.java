import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import components.*;
public class Main {


    public static void main(String[] args) throws ParseException {
        Janela tp = new Janela();
      /*
        SwingUtilities.invokeLater(new Janela() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createUIComponents();
            }
        });
*/
        FileParser firstFile = new FileParser();
        int checkStatus = 0;

        try{
            checkStatus = firstFile.lineReaderParse();

        }catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        ArrayList<String> b = firstFile.arrayRefVar;

    //Efeitos de teste
        if(checkStatus == 200){
            System.out.println(firstFile.arrayRefVar.get(0));
            System.out.println(firstFile.arrayRefVar.size());
        }
        System.out.println("Tester2");
    }
}
