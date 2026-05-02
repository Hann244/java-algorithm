import java.util.*;

class Solution {
    static class WordInfo {
        String text;
        int start;
        int end;
        
        WordInfo(String text, int start, int end) {
            this.text = text;
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        List<WordInfo> allWords = new ArrayList<>();
        
        int wordStart = -1;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != ' ') {
                if (wordStart == -1) wordStart = i;
            } else {
                if (wordStart != -1) {
                    allWords.add(new WordInfo(message.substring(wordStart, i), wordStart, i - 1));
                    wordStart = -1;
                }
            }
        }
        
        if (wordStart != -1) {
            allWords.add(new WordInfo(message.substring(wordStart), wordStart, message.length() - 1));
        }
        
        Set<String> normalWords = new HashSet<>();
        List<String> spoiledWords = new ArrayList<>();
        
        for (WordInfo word : allWords) {
            boolean isSpoiled = false;
            for (int[] range : spoiler_ranges) {
                int s_start = range[0];
                int s_end = range[1];
                
                if (word.start <= s_end && word.end >= s_start) {
                    isSpoiled = true;
                    break;
                }
            }
            
            if (isSpoiled) {
                spoiledWords.add(word.text);
            } else {
                normalWords.add(word.text);
            }
        }
        
        Set<String> importantWords = new HashSet<>();
        
        for (String wordText : spoiledWords) {
            if (!normalWords.contains(wordText) && !importantWords.contains(wordText)) {
                importantWords.add(wordText);
                answer++;
            }
        }
        
        return answer;
    }
}