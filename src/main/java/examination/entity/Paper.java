package examination.entity;

public class Paper {
    private Long id;
    private String name;
    private String choi;
    private String judg;
    private String sub;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChoi() {
        return choi;
    }

    public void setChoi(String choi) {
        this.choi = choi;
    }

    public String getJudg() {
        return judg;
    }

    public void setJudg(String judg) {
        this.judg = judg;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", choi='" + choi + '\'' +
                ", judg='" + judg + '\'' +
                ", sub='" + sub + '\'' +
                '}';
    }
}
