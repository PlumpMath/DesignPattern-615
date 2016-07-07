import SimpleFactory.Operation;
import SimpleFactory.OperationFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by wosyo on 2016/7/3.
 */
public class Main {


    public static void main(String[] arg) {
        useSimpleFactory();

    }

    /**
     * 设计模式——简单工厂模式实现
     */
    private static void useSimpleFactory() {
        Double number1, number2;
        String strOperation;
        System.out.print("请输入第一个数字：");
        number1 = Double.parseDouble(inputString());
        System.out.print("请输入运算符号：");
        strOperation = inputString();
        Operation operation = OperationFactory.creatOperation(strOperation);//简单工厂模式运用
        if (operation == null) {
            return;
        }
        System.out.print("请输入第二个数字：");
        number2 = Double.parseDouble(inputString());

        operation.setmNumber1(number1);
        operation.setmNumber2(number2);
        System.out.println(number1 + " " + strOperation + " " + number2 + " = " + operation.GetResult());
    }


    /**
     * 输入数据
     *
     * @return
     */
    private static String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


    /**
     * 输入方法第一种
     */
    private static void systemIn01() {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
