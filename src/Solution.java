public class Solution {
    public static void main(String[] args) {
        String number1 = "+ 7  98 5 123456 7";
        String number2 = ")+() 79(6)7 12345 67";
        String number3 = " + 7 ( )) ( (()";
        String number4 = "+79031234567";
        String number5 = "89251234567890";
        String number6 = "89061234567";

        String[] res1 = Change_Number(number1);
        String[] res2 = Change_Number(number2);
        String[] res3 = Change_Number(number3);
        String[] res4 = Change_Number(number4);
        String[] res5 = Change_Number(number5);
        String[] res6 = Change_Number(number6);

        Output_Result(res1);
        Output_Result(res2);
        Output_Result(res3);
        Output_Result(res4);
        Output_Result(res5);
        Output_Result(res6);
    }

    public static String[] Change_Number(String number) {
        String[] result = new String[2];
        String flag = "";         // "" - не было изменений, 2 - замена +7 на 8, 1 - удалены пробелы и скобки, 12 - и то, и то
        int len1 = number.length();
        number = number.replace(" ", ""); // удаление пробелов
        number = number.replace("(", ""); // удаление открывающей скобки
        number = number.replace(")", ""); // удаление закрывающей скобки
        if (number.length() < len1) {
            flag = flag + "1";
        }
        if (number.charAt(0) == '+' && number.charAt(1) == '7') {
            number = number.replaceFirst("\\+7", "8");
            flag = flag + "2";
        }
        switch (flag) {
            case "1":
                result[1] = "В номере есть пробелы и/или скобки";
                break;
            case "2":
                result[1] = "Замена +7 на 8";
                break;
            case "12":
                result[1] = "Замена +7 на 8; В номере есть пробелы и/или скобки";
                break;
            case "":
                result[1] = "Не было изменений";
                break;
        }
        if (number.length() != 11) {
            result[0] = "Введен некорректный номер";
            if (number.length() > 11) {
                result[1] = result[1] + "; " + "Сумма символов больше 11";
            } else {
                result[1] = result[1] + "; " + "Сумма символов меньше 11";
            }
        } else {
            result[0] = number;
        }
        return result;
    }

    public static void Output_Result(String[] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        System.out.println();
    }
}