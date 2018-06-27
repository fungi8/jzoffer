package jzoffer;

/**
 * create by fungus on 2018/6/26
 * <p>
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * <p>
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * <p>
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 **/

public class ReverseSentence {
    public static String ReverseSentence(String str) {
        if (str == null || str.length() < 2) return str;
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = str.split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            stringBuilder.append(strings[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public class Solution {
        public String ReverseSentence(String str) {
            if (str == null || str.length() == 0 || str.trim().length() == 0)
                return str;
            StringBuffer sb = new StringBuffer();
            String[] s = str.trim().split(" ");
            for (int i = s.length - 1; i >= 0; i--) {
                if (s[i] != "") sb.append(s[i]);
                if (i - 1 >= 0) sb.append(" ");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence(" "));
    }
}
