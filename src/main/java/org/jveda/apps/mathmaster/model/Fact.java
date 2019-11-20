package org.jveda.apps.mathmaster.model;

public class Fact {

    private Integer first;
    private Integer second;
    private Integer result;
    private String help;

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getFirst() {
        return this.first;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getSecond() {
        return this.second;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getResult() {
        return this.result;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

}