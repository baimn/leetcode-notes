package p0005;

/**
 * Created by apple on 2021/9/27.
 */
class Solution {
    public String longestPalindrome(String s) {
        return v2(s);
    }

    //O(n^2) to O(n^3), this is shit
    //Time Limit Exceeded
    //no doubt
    public String v1(String s) {
        int len = s.length();
        String result = s.charAt(0) + ""; // since the >= 1 as told
        for (int i = 0; i < len; ++i) {
            for (int j = i + 1; j < len; ++j) {
                String sub = s.substring(i, j + 1);
                if (isPalindromic(sub) && j - i + 1 > result.length()) {
                    result = sub;// new longest
                }
            }
        }
        return result;
    }

    //judge a string is palindromic or not
    public boolean isPalindromic(String s) {
        if (s.length() == 0) {// useless in this question
            return false;
        }
        for (int i = 0, j = s.length() - 1; i <= j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    //judge a string is palindromic or not
    //try to optimise by string reverse
    public boolean isPalindromicV2(String str) {
        String reverse = new StringBuffer(str).reverse().toString();
        return reverse.equals(str) ? true : false;
    }


    // expand from the center
    // the center is a string of one or some duplicate chars
    // O(n) to O(n^2)
    public String v2(String s) {
        int len = s.length();
        int count, minus, plus;
        String res = String.valueOf(s.charAt(0));

        for (int i = 0; i < len; i++) {
            for (minus = i, plus = i + 1; minus >= 0 && plus < len; plus++) {
                // broaden the center substring
                if (minus == i && s.charAt(plus) == s.charAt(i)) {
                    count = plus - minus + 1;
                    if (count > res.length()) {
                        res = s.substring(minus, plus + 1);
                    }
                    continue;
                } else {//not palindomic
                    if (minus == i && i > 0) {
                        minus--; // only once when minus is still i
                    }
                    // the center has been set
                    if (s.charAt(minus) == s.charAt(plus)) {//palindromic, expand
                        count = plus - minus + 1;
                        if (count > res.length()) {
                            res = s.substring(minus, plus + 1);
                        }
                        minus--;
                        continue;
                    } else {//not palindomic, stop
                        break;
                    }
                }
            }
        }
        return res;
    }


}
