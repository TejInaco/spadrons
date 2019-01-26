package tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parserText.StringsParser;
import java.util.ArrayList;

public class TestStringsParser {
    public ArrayList<String> statementsAll = new ArrayList<>();


    public TestStringsParser() {
        statementsAll.add("Nao nunca vi ninguem.");
        statementsAll.add("Fiquei eloquente de te ver no brilho das folhas");
        statementsAll.add("Mas fiquei olhei e sonhei, braços de volta do teu calor");
        statementsAll.add("Amei cri e cresci, foi como alguem que sempre se perdeu na serra");

        StringsParser fd = new StringsParser(statementsAll);

        Assertions.assertEquals(fd,this.statementsAll);

    }
    @Test
    public void contructString(){

    }

}
