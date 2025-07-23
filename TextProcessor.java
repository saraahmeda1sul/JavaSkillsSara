public class TextProcessor {
    public static int countWords(String sentence){
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;}
        String[] words = sentence.trim().split("\\s+");
        return words.length;}
    public static String replaceWord(String text, String oldWord, String newWord) {
        if (text == null || oldWord == null || newWord == null) {
            return text;}
        return text.replace(oldWord, newWord);}
    public static void main(String[] args) {
        String input = "Java is fun and Java is powerful";
        int wordCount = countWords(input);
        System.out.println("Word count: " + wordCount);
        String replaced = replaceWord(input, "Java", "Programming");
        System.out.println("Replaced sentence: " + replaced);
    }

}
