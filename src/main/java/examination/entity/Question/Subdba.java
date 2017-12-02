package examination.entity.Question;

public class Subdba {
    private Long id;
    private String question;
    private String refanswer;

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

    public String getRefanswer() {
        return refanswer;
    }

    public void setRefanswer(String refanswer) {
        this.refanswer = refanswer;
    }

    @Override
    public String toString() {
        return "Subdba{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", refanswer='" + refanswer + '\'' +
                '}';
    }
}
