package SimpleFactory;

/**
 * Created by wosyo on 2016/7/3.
 */
public abstract class Operation {
    private double mNumber1 = 0;
    private double mNumber2 = 0;

    public double getmNumber1() {
        return mNumber1;
    }

    public void setmNumber1(double mNumber1) {
        this.mNumber1 = mNumber1;
    }

    public double getmNumber2() {
        return mNumber2;
    }

    public void setmNumber2(double mNumber2) {
        this.mNumber2 = mNumber2;
    }

    public abstract double GetResult();


}
