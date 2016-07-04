package SimpleFactory;

/**
 * Created by wosyo on 2016/7/3.
 */
public class OperationDiv extends Operation {
    @Override
    public double GetResult() {
        if(getmNumber2()==0){
            try {
                throw new Exception("除数不能为零");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        double douResult = getmNumber1() / getmNumber2();
        return douResult;
    }
}
