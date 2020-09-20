package cn.tedu.algorithm.hash;

/**
 * @Date 2020/9/13 14:21
 * @Created by liukaihua
 */
public class FirstUniqChar {

    public int firstUniqChar(String s){
        int[] freq = new int[26];
        for (int i=0;i<s.length();i++){
            freq[s.charAt(i) - 'a'] ++;
        }
        for (int i=0;i<s.length();i++){
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
