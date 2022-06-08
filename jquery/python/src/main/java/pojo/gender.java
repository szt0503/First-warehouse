package pojo;
public class gender {
    private String woman;
    private String man;
    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    public String getWoman() {
        return woman;
    }

    public void setWoman(String woman) {
        this.woman = woman;
    }

    @Override
    public String toString() {
        return "gender{" +
                "man='" + man + '\'' +
                ", woman='" + woman + '\'' +
                '}';
    }
}
