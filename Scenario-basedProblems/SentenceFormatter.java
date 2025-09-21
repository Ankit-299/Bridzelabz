public class SentenceFormatter {

    public static String formatSentence(String paragraph) {
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "";
        }

        String cleanedParagraph = paragraph.replaceAll("\\s+", " ").trim();
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (int i = 0; i < cleanedParagraph.length(); i++) {
            char currentChar = cleanedParagraph.charAt(i);
            if (capitalizeNext && Character.isLetter(currentChar)) {
                result.append(Character.toUpperCase(currentChar));
                capitalizeNext = false;
            } else {
                result.append(currentChar);
            }

            if (currentChar == '.' || currentChar == '?' || currentChar == '!') {
                capitalizeNext = true;
                if (i + 1 < cleanedParagraph.length() && cleanedParagraph.charAt(i + 1) != ' ') {
                    result.append(' ');
                }
            }
        }
        return result.toString();
    }
}
