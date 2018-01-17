package examination.entity;

public class JudgeQuestion {
    long id;
    String question;
    String rightAnswer;
    byte secrecy;

    public JudgeQuestion() {
    }

    public JudgeQuestion(String question, String rightAnswer) {
        this.question = question;
        this.rightAnswer = rightAnswer;
    }

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
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
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
                ", rightAnswer='" + rightAnswer + '\'' +
                ", secrecy=" + secrecy +
                '}';
    }
}
