package examination.entity;

public class Record {
    long sid;
    long pid;
    String record;
    String status;
    long score;

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Record{" +
                "sid=" + sid +
                ", pid=" + pid +
                ", record='" + record + '\'' +
                ", status='" + status + '\'' +
                ", score=" + score +
                '}';
    }
}
