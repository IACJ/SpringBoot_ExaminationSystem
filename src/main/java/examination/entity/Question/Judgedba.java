package examination.entity.Question;

public class Judgedba {
    private Long id;
    private String question;
    private String rightanswer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRightanswer() {
        return rightanswer;
    }

    public void setRightanswer(String rightanswer) {
        this.rightanswer = rightanswer;
    }

    @Override
    public String toString() {
        return "Judgedba{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", rightanswer='" + rightanswer + '\'' +
                '}';
    }
}
