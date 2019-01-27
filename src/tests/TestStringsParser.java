package tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parserText.StringsParser;
import java.util.ArrayList;

public class TestStringsParser {
    public ArrayList<String> statementsAll = new ArrayList<>();
    public StringsParser fd = new StringsParser();


    public TestStringsParser() {
        statementsAll.add("Nao nunca vi ninguem.");
        statementsAll.add("Fiquei eloquente de te ver no brilho das folhas");
        statementsAll.add("Mas fiquei olhei e sonhei, braços de volta do teu calor");
        statementsAll.add("Amei cri e cresci, foi como alguem que sempre se perdeu na serra");
        statementsAll.add("Estou a viver - Sim, estou, decerto... Sem querer ! mas la estou ?");
        this.fd.frases = statementsAll;
        String srt = new String("Nao nunca vi ninguem.");
        String srt1 = new String("Fiquei eloquente de te ver no brilho das folhas");
        String srt2 = new String("Mas fiquei olhei e sonhei, braços de volta do teu calor");
        String srt3 = new String("Amei cri e cresci, foi como alguem que sempre se perdeu na serra");

        Assertions.assertEquals(0,fd.numero);
        Assertions.assertEquals(srt, fd.frases.get(0));
        Assertions.assertEquals(srt1, fd.frases.get(1));
        Assertions.assertEquals(srt2, fd.frases.get(2));
        Assertions.assertEquals(srt3, fd.frases.get(3));
        Assertions.assertEquals(0,fd.numero);
    }
    @Test
    public void t_dealingString(){
        String srt = new String("Nnvn._4");    //Primeira letra de cada palavra
        String srt1 = new String("FEdtvnbdf_9"); //Todas as maisculas contam e processar as vogais em maisculas //TODO
        String srt2 = new String("MfOEs,bdvdtc_11"); //Inserir todos os sinais de pontuacao
        String srt3 = new String("AcEc,fcAqsspns_13");
        String srt4 = new String("EAv-S,E,d...Sq!mlE?_11");

        Assertions.assertEquals(    srt ,     this.fd.dealingString(this.statementsAll.get(0))    );
        Assertions.assertEquals(    srt1 ,    this.fd.dealingString(this.statementsAll.get(1))    );
        Assertions.assertEquals(    srt2 ,    this.fd.dealingString(this.statementsAll.get(2))    );
        Assertions.assertEquals(    srt3 ,    this.fd.dealingString(this.statementsAll.get(3))    );
        Assertions.assertEquals(    srt4 ,    this.fd.dealingString(this.statementsAll.get(4))    );


    }

}
