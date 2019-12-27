package com.zhangze.sword;

/**
 * 17、打印从1到最大的n位数 -------------
 * 输入数字N，按顺序打印出从1到最大的n位十进制数，比如输入3，则打印1,2,3，一直到最大的3为数999
 */
public class Print1ToMaxOfNDigits {

    public void print(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        print(number, 0);
    }
    private void print(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10;i++) {
            number[digit] = (char)(i + '0');
            print(number, digit + 1);
        }
    }
    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0') {
            index++;
        }
        while (index < number.length) {
            System.out.print(number[index++]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception{
        Print1ToMaxOfNDigits.class.newInstance().print(3);
    }
}
