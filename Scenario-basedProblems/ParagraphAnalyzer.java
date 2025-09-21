import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphAnalyzer {

    private String paragraph;

    public ParagraphAnalyzer(String paragraph) {
        if (paragraph == null) {
            this.paragraph = "";
        } else {
            this.paragraph = paragraph;
        }
    }

    public int countWords() {
        if (paragraph.trim().isEmpty()) {
            return 0;
        }
        String[] words = paragraph.trim().split("\\s+");
        return words.length;
    }

    public String findLongestWord() {
        if (paragraph.trim().isEmpty()) {
            return "";
        }
        String[] words = paragraph.trim().split("\\s+");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    public String replaceWord(String oldWord, String newWord) {
        String regex = "(?i)\\b" + Pattern.quote(oldWord) + "\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(paragraph);
        return matcher.replaceAll(newWord);
    }
}
