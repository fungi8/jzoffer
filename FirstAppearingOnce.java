package jzoffer;

/**
 * create by fungus on 2018/6/27
 * <p>
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，
 * <p>
 * 当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 **/

public class FirstAppearingOnce {


    //Insert one char from string stream
    //int型数组表示256个字符，这个数组初值置为-1.
    //每读一个字符，将该字符的位置存入字符对应数组下标中。
    private int[] occurrences = new int[256];
    private int index;

    public FirstAppearingOnce() {
        for (int i = 0; i < 256; i++) {
            occurrences[i] = -1;
        }
        index = 0;
    }

    public void Insert(char ch) {
        //她的第一次吖
        if (occurrences[ch] == -1) {
            occurrences[ch] = index;
            //她的第二次，不要啦
        } else if (occurrences[ch] >= 0) {
            occurrences[ch] = -2;
        }
        //你是几号啊
        index++;
    }

    //return the first appearence once char in current string stream
    public char FirstAppearingOnce() {
        char ch = '\0';
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            // 只有她是第一次才统计
            if (occurrences[i] >= 0 && occurrences[i] < minIndex) {
                ch = (char) i;
                minIndex = occurrences[i];
            }
        }
        if (ch == '\0') {
            return '#';
        }
        return ch;
    }
}
