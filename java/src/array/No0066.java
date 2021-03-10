class No0066 {
    public int[] plusOne(int[] digits) {
        return v1(digits);
    }

    //v1
    //Runtime:0ms,100%, Memory:37.2MB,90.31%
    //逻辑清晰，从最后一位向前进位
    //同时准备好dec数组，以备出现999的情况，需要扩展数组长度+1为1000
    public int[] v1(int[] digits) {
        int[] dec = new int[digits.length + 1];
        for (int i = digits.length - 1; i >= 0; --i) {
            if (0 == i && 9 == digits[i]) {
                dec[0] = 1;
                dec[1] = 0;
                return dec;
            }
            if (9 != digits[i]) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
                dec[i + 1] = 0;
                continue;
            }
        }
        return digits;
    }
}
