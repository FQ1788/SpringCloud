package demo.bean;

import java.util.List;

public class DemoB {
    
    private Integer id;
    
    private List<DemoA> data;

    public DemoB() {
    }

    public DemoB(Integer id, List<DemoA> data) {
        this.id = id;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<DemoA> getData() {
        return data;
    }

    public void setData(List<DemoA> data) {
        this.data = data;
    }
}
