package rank6kyu;

import java.util.*;

public class TheEnigmaMachineThePlugboard {

    private Map<Character, Character> pairs = new HashMap<>();

    public TheEnigmaMachineThePlugboard(String wires) throws InvalidPlugboardWiresException {
        System.out.println(wires);
        setPairs(wires);
    }

    private void setPairs(String wires) throws InvalidPlugboardWiresException {
        if (wires == null || wires.length() % 2 != 0 || wires.isEmpty() || wires.length() > 26) {
            throw new InvalidPlugboardWiresException();
        }
        for (int i = 0; i < wires.length(); i += 2) {
            if (mapHasAsKeyOrValue(wires.charAt(i)) || mapHasAsKeyOrValue(wires.charAt(i + 1))) {
                throw new InvalidPlugboardWiresException();
            }
            pairs.put(wires.charAt(i), wires.charAt(i + 1));
            pairs.put(wires.charAt(i + 1), wires.charAt(i));
        }
    }

    private boolean mapHasAsKeyOrValue(char symbol) {
        for (Map.Entry<Character, Character> entry : pairs.entrySet()) {
            if (entry.getValue().equals(symbol) || entry.getKey().equals(symbol)) {
                return true;
            }
        }
        return false;
    }


    public String process(String wire) {
        char[] chars = wire.toCharArray();
        String res = "";
        for (char symbol : chars) {
            res += getCodedSymbol(symbol);
        }
        return res;
    }

    private String getCodedSymbol(char symbol) {
        for (Map.Entry<Character, Character> entry : pairs.entrySet()) {
            if (entry.getKey().equals(symbol)) {
                return String.valueOf(entry.getValue());
            }
        }
        return String.valueOf(symbol);
    }



//    public static void main(String[] args) {
//        TheEnigmaMachineThePlugboard plugboard = new TheEnigmaMachineThePlugboard("ABCDEFGHIJKLMNOPQ");
//        String wire = "ZXCTVBNM<YVTRCRCTFVGHKTVRXWERTYBU<>";
//        System.out.println(122);
//        System.out.println(wire);
//        System.out.println(plugboard.process(wire));
//    }
}


class InvalidPlugboardWiresException extends Throwable{

}