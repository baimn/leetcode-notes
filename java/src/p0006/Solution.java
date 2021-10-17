package p0006;

/**
 * Created by baimn on 2021/10/17.
 */
class Solution {
    public String convert(String s, int numRows) {
        return v1(s, numRows);
    }

    public String v1(String s, int numRows) {
        int len = s.length();
        if (1 == numRows || 1 == len || len < numRows) {
            return s;
        }
        int mod = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            //row by row
            boolean devide = (row == 0 || row == numRows - 1) ? false : true;
            int index = row;
            int step = 2 * row;
            do {
                sb.append(s.charAt(index)); // append
                step = devide ? mod - step : mod; // change step
                index += step; // to next char
            } while (index < len);
        }
        return sb.toString();
    }

}