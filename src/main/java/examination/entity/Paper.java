package examination.entity;

public class Paper {
    private Long id;
    private String name;
    private String begintime;
    private String finishtime;
    private String choi;
    private String judg;
    private String sub;

    private String choiscore;
    private String judgscore;
    private String subscore;


    private long tid;
    private String classid;

    public Paper() {
    }

    public Paper(String name, String begintime, String finishtime, String choi,
                 String judg, String sub, long tid, String classid) {
        this.name = name;
        this.begintime = begintime;
        this.finishtime = finishtime;
        this.choi = choi;
        this.judg = judg;
        this.sub = sub;
        this.tid = tid;
        this.classid = classid;
    }

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

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(String finishtime) {
        this.finishtime = finishtime;
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

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getChoiscore() {
        return choiscore;
    }

    public void setChoiscore(String choiscore) {
        this.choiscore = choiscore;
    }

    public String getJudgscore() {
        return judgscore;
    }

    public void setJudgscore(String judgscore) {
        this.judgscore = judgscore;
    }

    public String getSubscore() {
        return subscore;
    }

    public void setSubscore(String subscore) {
        this.subscore = subscore;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", begintime='" + begintime + '\'' +
                ", finishtime='" + finishtime + '\'' +
                ", choi='" + choi + '\'' +
                ", judg='" + judg + '\'' +
                ", sub='" + sub + '\'' +
                ", choiscore='" + choiscore + '\'' +
                ", judgscore='" + judgscore + '\'' +
                ", subscore='" + subscore + '\'' +
                ", tid=" + tid +
                ", classid='" + classid + '\'' +
                '}';
    }
}
