package examination.entity;

public class JudgeQuestion {
    long id;
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    String rightAnswer;
    byte secrecy;
    short chapters;

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

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
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

    public short getChapters() {
        return chapters;
    }

    public void setChapters(short chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "ChoiceQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                ", secrecy=" + secrecy +
                ", chapters=" + chapters +
                '}';
    }
}
