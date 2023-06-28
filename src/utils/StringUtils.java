package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static String[] findAllMatches(String s, String regex){
        List<String> matches = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            matches.add(matcher.group());
        }
        return (String[]) matches.toArray();
    }

    public boolean isStringEmail(String s){
        return s.contains("@") && s.contains(".");
    }

    public static int countWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return 0;
        }

        String[] words = sentence.split(" ");
        return words.length;
    }

    public static boolean isAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Input strings cannot be null");
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    public static String normalizeText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null");
        }

        // Remove extra spaces
        String normalized = text.replaceAll("\\s+", " ");

        // Convert to lowercase
        normalized = normalized.toLowerCase();

        // Trim leading and trailing spaces
        normalized = normalized.trim();

        return normalized;
    }
}
