package parserText;

import java.util.ArrayList;

public class StringsParser {
    public ArrayList<String> frases = new ArrayList<String>();
    public ArrayList<String> padroes = new ArrayList<String>();
    public int numero = 0;

    public StringsParser(ArrayList<String> b){
        this.frases = b;
    }
    public ArrayList<String> getFrases() {
        return frases;
    }

    public ArrayList<String> getPadroes() {
        return padroes;
    }

    public void setFrases(ArrayList<String> frases) {
        this.frases = frases;
    }

    public void setPadroes(ArrayList<String> padroes) {
        this.padroes = padroes;
    }

    public int getNumero() {
        return numero;
    }


    public void startDecompost(int c){
        switch(c){
            case 0:
                break;
            case 1:
                this.algure1();
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    public void algure1(){

        for(String ite: this.frases) {
            String str =  dealingString(ite);
            this.padroes.add(str);
        }
    }

    public String dealingString(String str){
        int estado = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            switch (estado) {
                case 0:
                    char c = str.charAt(i);
                    sb.append(c);
                    estado = 1;
                    break;
                case 1:
                    //espaços em branco Unicode whitespace character
                    if (Character.isWhitespace(str.charAt(i))) {
                        estado = 0;
                    }
//        If you mean any of the traditional ASCII whitespace characters (SP, HT, VT, CR, NL), then:
//    if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n' || ch == '\x0b') {
//    }
//          traditional ASCII whitespace
                    if (str.charAt(i) == ' ') {
                        estado = 0;
                    }
                    //tabs
                    if (str.charAt(i) == '\t') {
                        estado = 0;
                    }
                    //If you mean any Unicode whitespace character, then:
                    //            if (Character.isWhitespace(ch)) {
                    //            }
                    if (!Character.isAlphabetic(str.charAt(i)) && i + 1 > str.length()) {
                        sb.append(str.charAt(i));
                    }
                    break;
                default:
                    break;

            }
        }
    return str;
    }

}
