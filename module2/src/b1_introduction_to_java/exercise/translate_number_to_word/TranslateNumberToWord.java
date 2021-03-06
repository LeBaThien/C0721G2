package b1_introduction_to_java.exercise.translate_number_to_word;

import java.util.Scanner;

public class TranslateNumberToWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your number: ");
        int numberInput = scanner.nextInt();
        int unit = numberInput % 10;
        int ten = (numberInput % 100) / 10;
        int hundered = (numberInput % 1000) / 100;
        System.out.printf("" + unit + "\r");
        System.out.printf("" + ten + "\r");
        System.out.printf("" + hundered + "\r");

        String unitString = "";
        switch (unit) {
            case 0:
                unitString = "";
                break;
            case 1:
                unitString = "one";
                break;
            case 2:
                unitString = "two";
                break;
            case 3:
                unitString = "three";
                break;
            case 4:
                unitString = "four";
                break;
            case 5:
                unitString = "five";
                break;
            case 6:
                unitString = "six";
                break;
            case 7:
                unitString = "seven";
                break;
            case 8:
                unitString = "eight";
                break;
            case 9:
                unitString = "nine";
                break;

        }
        String tenString = "";
        switch (ten) {
            case 1:
                switch (unit) {
                    case 0:
                        unitString = "ten";
                        break;
                    case 1:
                        unitString = "eleven";
                        break;
                    case 2:
                        unitString = "twelve";
                        break;
                    case 3:
                        unitString = "thirteen";
                        break;
                    case 4:
                        unitString = "fourteen";
                        break;
                    case 5:
                        unitString = "fifteen";
                        break;
                    case 6:
                        unitString = "sixteen";
                        break;
                    case 7:
                        unitString = "seventeen";
                        break;
                    case 8:
                        unitString = "eightteen";
                        break;
                    case 9:
                        unitString = "nineteen";
                        break;

                }
                break;
            case 2:
                tenString = "twenty";
                break;
            case 3:
                tenString = "thirty";
                break;
            case 4:
                tenString = "fourty";
                break;
            case 5:
                tenString = "fifty";
                break;
            case 6:
                tenString = "sixty";
                break;
            case 7:
                tenString = "seventy";
                break;
            case 8:
                tenString = "eighty";
                break;
            case 9:
                tenString = "ninety";
                break;
        }
        String hundredString = "";
        switch (hundered) {
            case 1:
                hundredString = "one";
                break;
            case 2:
                hundredString = "two";
                break;
            case 3:
                hundredString = "three";
                break;
            case 4:
                hundredString = "four";
                break;
            case 5:
                hundredString = "five";
                break;
            case 6:
                hundredString = "six";
                break;
            case 7:
                hundredString = "seven";
                break;
            case 8:
                hundredString = "eight";
                break;
            case 9:
                hundredString = "nine";
                break;
        }

        if (numberInput >= 0) {
            if (numberInput < 20) {
                switch (numberInput) {
                    case 0:
                        System.out.printf("zero");
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 15:
                    case 14:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        System.out.printf("" + unitString);
                        break;
                }
            } else if (numberInput < 100) {
                System.out.printf("%s%s", tenString, unitString);
            } else if (numberInput < 1000) {
                System.out.printf("%s hundred and %s%s", hundredString, tenString, unitString);
            } else {
                System.out.printf("Out of ability");
            }
        } else {
            System.out.printf("Out of ability");
        }
    }

}
            //    k?? t??? xu???ng d??ng v?? ng???t d??ng (c??c k?? t??? /n, /r),
            //%c: K?? t???
            //%d: S??? th???p ph??n (s??? nguy??n) (c?? s??? 10)
            //%e: D???u ph???y ?????ng theo c???p s??? nh??n
            //%f: D???u ph???y ?????ng
            //%i: S??? nguy??n (c?? s??? 10)
            //%o: S??? b??t ph??n (c?? s??? 8)
            //%s: Chu???i
            //%u: S??? th???p ph??n (s??? nguy??n) kh??ng d???u
            //%x: S??? trong h??? th???p l???c ph??n (c?? s??? 16)
            //%t: ?????nh d???ng ng??y / gi???
            //%%: D???u ph???n tr??m
            //\%: D???u ph???n tr??m


