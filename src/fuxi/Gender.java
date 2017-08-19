package fuxi;


/**
 * Created by 1 on 2017/7/9.
 */
public enum Gender {
    MAN("Man") {
        @Override
        public String getName() {
            return this.getValue();
        }
    },WOMAN("Woman") {
        @Override
        public String getName() {
            return "女";
        }
    };

    private String value;
    Gender(String man) {
        this.value = man;
    }
    public String getValue() {
        return value;
    }

    public abstract String getName();



}
