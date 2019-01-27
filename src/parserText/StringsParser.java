package parserText;

import java.util.ArrayList;

public class StringsParser {
    public ArrayList<String> frases = new ArrayList<String>();
    public ArrayList<String> padroes = new ArrayList<String>();
    public int numero = 0;

    public StringsParser(){}
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

    /**
     *
     * @param c choice number to choose differents state machines
     *
     * */
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

    /**
     * Precorrer a array frases e passa os chares processados para a string secundaria
     * */
    public void algure1(){

        for(String ite: this.frases) {
            String str =  dealingString(ite);
            this.padroes.add(str);
        }
    }

    /**
     * @param str frase a ser processa, cada index da array frases
     * @return  nova string
     * */
    public String dealingString(String str){
        int estado = 0;
        StringBuilder sb = new StringBuilder();
        String regex = "^(?=.*?\\p{Lu})(?=.*?\\p{L})(?=.*?\\d)" +
               "(?=.*?[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?]).*$" ;
        for (int i = 0; i < str.length(); i++) {
            switch (estado) {
                case 0:
                    char letter = str.charAt(i);
                    char newletter;
                    char[] list = {'a', 'e', 'i', 'o', 'u'};
                    for(char dalist: list){
                        if ( Character.compare( dalist, letter) == 0) {
                            newletter = Character.toUpperCase(letter);
                            letter = newletter;

                        }
                    }
                    sb.append(letter);
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
                    //            if (Character.isWhitespace(ch)) }
                    if (    !Character.isAlphabetic(str.charAt(i)) && !Character.isWhitespace(str.charAt(i))  ) {
                        sb.append(str.charAt(i));
                    }
                    break;
                default:
                    break;

            }
        }
        int lengthSize = processLastElement(sb);
        sb.append('_');
        sb.append(lengthSize);
        String sb_string = sb.toString();
        return sb_string;
    }

    public int processLastElement(StringBuilder strHalfWay){
        int i;
        int number=0;
        for(i=0; i < strHalfWay.length(); i++)
            if (    Character.isLetter( strHalfWay.charAt(i))   ) {
                number++;
            }
        return number;
    }

}
