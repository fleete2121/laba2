package org.example;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StringProcessor {
    String RepeatString(String s, int N) throws InvalidParameterException {
        if (N == 0) return "";
        if (N < 0) throw new InvalidParameterException("Количество строк меньше 0");

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < N; i++){
            str.append(s);
        }

        return str.toString();
    }

    int CountSubString(String s1, String s2) throws InvalidParameterException{
        if (Objects.equals(s2, "")) throw new InvalidParameterException("Вторая строка пустая");

        int count = 0;
        int lastIndex = 0;

        while (lastIndex != -1) {
            lastIndex = s1.indexOf(s2, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += s2.length();
            }
        }

        return count;
    }

    public String ReplaceNumberToWordIntoString(String s) {
        Map<Integer, String> dict = new HashMap<Integer, String>();
        dict.put(1, "Один");
        dict.put(2, "Два");
        dict.put(3, "Три");

        StringBuilder s1 = new StringBuilder(s);

        for (int i = 1; i <= 3; i++) {
            int index = 0;
            while (index != -1) {
                index = s1.indexOf(Integer.toString(i), index);
                if (index != -1) {
                    s1.replace(index, index + 1, dict.get(i));
                    index += dict.get(i).length(); // Обновляем индекс после замены
                }
            }
        }

        return s1.toString();
    }

    public void RemoveEverySecondChar(StringBuilder s){
        for (int i = 1; i <s.length(); i += 1) {
            s.deleteCharAt(i);
        }
    }
}
