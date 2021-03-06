package datatypes;

import common.Constants;
import datatypes.base.DT_Numeric;

/**
 * Created by dakle on 10/4/17.
 */
public class DT_Double extends DT_Numeric<Double> {

    public DT_Double() {
        this(0, true);
    }

    public DT_Double(Double value) {
        this(value == null ? 0 : value, value == null);
    }

    public DT_Double(double value, boolean isNull) {
        super(Constants.DOUBLE_SERIAL_TYPE_CODE, Constants.EIGHT_BYTE_NULL_SERIAL_TYPE_CODE, Double.BYTES);
        this.value = value;
        this.isNull = isNull;
    }

    @Override
    public void increment(Double value) {
        this.value += value;
    }

    @Override
    public boolean compare(DT_Numeric<Double> object2, short condition) {
        switch (condition) {
            case DT_Numeric.EQUALS:
                return value == object2.getValue();

            case DT_Numeric.GREATER_THAN:
                return value > object2.getValue();

            case DT_Numeric.LESS_THAN:
                return value < object2.getValue();

            case DT_Numeric.GREATER_THAN_EQUALS:
                return value >= object2.getValue();

            case DT_Numeric.LESS_THAN_EQUALS:
                return value <= object2.getValue();

            default:
                return false;
        }
    }
}
