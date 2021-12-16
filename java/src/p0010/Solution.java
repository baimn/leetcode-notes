package p0010;

/**
 * Created by baimn on 2021/12/16.
 */
class Solution {
    public boolean isMatch(String s, String p) {
        return v2(s, p);
    }

    // a*   some a  F T
    //.*    some any T T
    // aa    one a   F F
    // .a    one letter T F
    public boolean v1(String s, String p) {
        int cs = 0, cp = 0; // cursors for s and p
        boolean isPoint = false, isStar = false; // cursors
        while (cp < p.length()) {
            // case classify
            isStar = (p.length() - 1 == cp || p.charAt(cp + 1) != '*') ? false : true;
            isPoint = p.charAt(cp) == '.' ? true : false;

            // ending situation
            if (cs >= s.length()) {
                if (p.length() - 1 == cp && (isStar || (p.charAt(cp) == s.charAt(cs - 1) && p.charAt(cp - 1) == '*'))) {
                    return true;
                }
                return false;
            }

            // deal with 4 circumstances
            if (isPoint && isStar) {
                if (cp == p.length() - 2) {
                    return true;
                } else {
                    return false; // rude return
                }
            } else if (isPoint && !isStar) {
                cs++;
                cp++;
            } else if (!isPoint && isStar) {
                char letter = p.charAt(cp);
                while (cs < s.length() && s.charAt(cs) == letter) {
                    cs++;
                }
                cp += 2;
            } else if (!isPoint && !isStar) {
                if (s.charAt(cs) == p.charAt(cp)) {
                    cs++;
                    cp++;
                } else {
                    return false;
                }
            }
        }
        if (cs == s.length() && cp == p.length()) {
            return true;
        }
        return false;
    }

    // v2
    // this is copied from leetcode-cn official
    public boolean v2(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


}