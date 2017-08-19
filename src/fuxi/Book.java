package fuxi;


/**
 * Created by 1 on 2017/7/9.
 */
public class Book {
    private String name;
    private int page = 100;

    public String getName() {
        return name;
    }

    public int getPage() {
        return page;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPage(int page) throws Exception {
        if (page >= 100) {
            this.page = page;
        } else {
            throw new Exception("页数不能少于100");
        }
    }

    @Override
    public String toString() {
        return "name: "+this.name+" page: "+this.page;
    }

}

