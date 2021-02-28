
public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) return s;
    int len = s.length();
    char[] sChar = s.toCharArray();
    int start = 0;
    int length = 1;
    boolean[][] isPalindrome = new boolean[len][len];
    for (int i = 0; i < len; i++) {
        isPalindrome[i][i] = true;
    }
    
    for (int i = 0; i < len - 1; i++) {
        if (sChar[i] == sChar[i + 1]) {
            isPalindrome[i][i + 1] = true;
            start = i;
            length = 2;
        }
    }
    
    for (int i = 3; i <= len; i++) { // length of the current string
        for (int j = 0; j + i - 1 < len; j++)  { // j 0-2 1-3 2-4 when length = 3
            if (sChar[j] == sChar[j + i - 1] && isPalindrome[j + 1][j + i -2] == true) {
                isPalindrome[j][j + i - 1] = true;
                start = j;
                length = i; // length is from 1 to maximum so the last one is the longest
            } 
        } 
    }
    
    return s.substring(start, start + length);
}
