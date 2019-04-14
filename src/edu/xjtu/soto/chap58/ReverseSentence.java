package edu.xjtu.soto.chap58;

/**
 *输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和就能字母一样处理。
 *
 * 例如，输入字符串“I am a student.”则输出"student. a am I".
 */
public class ReverseSentence {
    public String reverse(String sentence) {
        if (sentence == null || sentence.trim().equals("")) {
            return "";
        }
        String[] words = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseSentence rs = new ReverseSentence();
        String re = rs.reverse("I am a student.");

        System.out.println(re);

    }
}
