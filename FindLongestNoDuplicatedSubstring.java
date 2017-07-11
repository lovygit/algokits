public class FindLongestNoDuplicatedSubstring{
   public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int k = 0, max = 0, count = 1;
        boolean button=false;
        for (int i = 1; i < s.length(); i++) {
            for (int j = k; j < i; j++) {//k is always is the flag marked the possible start index
                if (s.charAt(i) == s.charAt(j)) {
                    if (count > max)
                        max = count;
                    count = count-j+k;
                    k = j + 1;
                    button = false;
                    break;
                }
                button = true;
            }
            if (button)
                count++;
            // System.out.println("i si "+i+" max is "+max+"k is "+k);
        }
        // System.out.println("count is "+count);
        return (count > max) ? count : max;
    }
}
