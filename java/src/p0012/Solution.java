package p0012;

/**
 * Created by baimn on 2021/8/21.
 */

class Solution {
    public String intToRoman(int num) {
        return v3(num);
    }

    //v1
    // the direct way
    //    Runtime: 15 ms, faster than 12.27% of Java online submissions for Integer to Roman.
    //    Memory Usage: 39.6 MB, less than 26.10% of Java online submissions for Integer to Roman.
    public String v1(int num) {
        String thousand = "";
        String hundred = "";
        String ten = "";
        String one = "";
        String[][] dictionary = {
                //10^0
                {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                //10^1
                {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                //10^2
                {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                //10^3
                {"M", "MM", "MMM"}
        };
        int round = 0;
        while (num > 0) {
            int cur = num % 10;
            num /= 10;
            if (cur == 0) {
                round++;
                continue;
            }
            if (round == 0) {
                one = dictionary[round][cur - 1];
            } else if (round == 1) {
                ten = dictionary[round][cur - 1];
            } else if (round == 2) {
                hundred = dictionary[round][cur - 1];
            } else if (round == 3) {
                thousand = dictionary[round][cur - 1];
            }
            round++;
        }
        return thousand + hundred + ten + one;
    }

    // v2
    // prettier!
    //    Runtime: 14 ms, faster than 19.24% of Java online submissions for Integer to Roman.
    //    Memory Usage: 39.6 MB, less than 26.10% of Java online submissions for Integer to Roman.
    public String v2(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    // v3
    // use string builder will improve much!
    // Runtime: 4 ms, faster than 77.05% of Java online submissions for Integer to Roman.
    // Memory Usage: 38.9 MB, less than 45.19% of Java online submissions for Integer to Roman.
    public String v3(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        StringBuilder roman = new StringBuilder();
        return roman.append(M[num / 1000]).append(C[(num % 1000) / 100]).append(X[(num % 100) / 10]).append(I[num % 10]).toString();
    }


}