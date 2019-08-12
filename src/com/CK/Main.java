package com.CK;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat fish";
        Solution solution = new Solution();
        System.out.println(solution.wordPattern(pattern,str));
    }
}

class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern.length() == 0 || str.length() == 0) return false;
        String[] strArr = str.split(" ");

        if (pattern.length() != strArr.length) return false;

        Map<Character, String> pToWord = new HashMap<>();
        HashSet<String> words = new HashSet<>();
        for (int i = 0; i < strArr.length; i++) {
            char p = pattern.charAt(i);
            String s = strArr[i];
            if (pToWord.isEmpty() || !pToWord.containsKey(p)){
                if (words.contains(s)) return false;
                pToWord.put(p, strArr[i]);
                words.add(s);
            } else {
                String word = pToWord.get(p);
                if (!word.equals(s))
                    return false;
            }
        }
        return true;
    }
}