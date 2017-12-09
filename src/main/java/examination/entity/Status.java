package examination.entity;

public class Status {
    long runid;
    long eid;
    long uid;
    String submit_time;
    String sql2;
    String status;

    public long getRunid() {
        return runid;
    }

    public void setRunid(long runid) {
        this.runid = runid;
    }

    public long getEid() {
        return eid;
    }

    public void setEid(long eid) {
        this.eid = eid;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(String submit_time) {
        this.submit_time = submit_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSql2() {
        return sql2;
    }

    public void setSql2(String sql2) {
        this.sql2 = sql2;
    }
}
