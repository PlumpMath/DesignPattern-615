package SimpleFactory;

/**
 * Created by wosyo on 2016/7/3.
 */
public class OperationSub extends Operation {
    @Override
    public double GetResult() {
        double douResult = getmNumber1() - getmNumber2();
        return douResult;
    }
}
