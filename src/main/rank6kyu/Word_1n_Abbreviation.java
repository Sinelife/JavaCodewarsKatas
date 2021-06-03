package rank6kyu;

public class Word_1n_Abbreviation {

    public static void main(String[] args) {
        Word_1n_Abbreviation w = new Word_1n_Abbreviation();
        System.out.println(w.abbreviate("internationalization"));
    }



    public String abbreviate(String string) {
        String word = "";
        String res = "";
        for (char symbol : string.toCharArray()) {
            if (isLetter(symbol)) {
                word += symbol;
            } else {
                res += getAbbriviatedWord(word) + symbol;
                word = "";
            }
        }
        return res + getAbbriviatedWord(word);
    }

    private String getAbbriviatedWord(String word) {
        return word.length() < 4 ? word : word.substring(0, 1) + (word.length() - 2) + word.substring(word.length() - 1);
    }

    private boolean isLetter(char symbol) {
        return (symbol >= 'a' && symbol <= 'z') || (symbol >= 'A' && symbol <= 'Z');
    }
}
