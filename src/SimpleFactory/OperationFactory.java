package SimpleFactory;

/**
 * Created by wosyo on 2016/7/3.
 */
public class OperationFactory {


    public static Operation creatOperation(String operation) {
        Operation operationBean=null;
        switch (operation) {
            case "+":
                operationBean=new OperationAdd();
                break;
            case "-":
                operationBean=new OperationSub();
                break;
            case "*":
                operationBean=new OperationMul();
                break;
            case "/":
                operationBean=new OperationDiv();
                break;
            default:
                System.out.println("运算符号错误！");
                break;
        }
        return operationBean;
    }
}
