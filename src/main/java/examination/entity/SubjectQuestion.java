package examination.entity;

public class SubjectQuestion {
    long id;
    String question;
    String refAnswer;
    byte secrecy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRightAnswer() {
        return refAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.refAnswer = rightAnswer;
    }

    public byte getSecrecy() {
        return secrecy;
    }

    public void setSecrecy(byte secrecy) {
        this.secrecy = secrecy;
    }

    @Override
    public String toString() {
        return "JudgeQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", rightAnswer='" + refAnswer + '\'' +
                ", secrecy=" + secrecy +
                '}';
    }
}
