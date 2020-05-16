package com.example.TestMe;

public class Question {
    private int id;
    private String question_text;
    private String choice_one;
    private String choice_two;
    private String choice_three;
    private String choice_four;


    public Question(int id, String question_text, String choice_one, String choice_two, String choice_three, String choice_four) {
        this.id = id;
        this.question_text = question_text;
        this.choice_one = choice_one;
        this.choice_two = choice_two;
        this.choice_three = choice_three;
        this.choice_four = choice_four;
    }

    public String getChoice_three() {
        return choice_three;
    }

    public void setChoice_three(String choice_three) {
        this.choice_three = choice_three;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getChoice_one() {
        return choice_one;
    }

    public void setChoice_one(String choice_one) {
        this.choice_one = choice_one;
    }

    public String getChoice_two() {
        return choice_two;
    }

    public void setChoice_two(String choice_two) {
        this.choice_two = choice_two;
    }

    public String getChoice_four() {
        return choice_four;
    }

    public void setChoice_four(String choice_four) {
        this.choice_four = choice_four;
    }
}
