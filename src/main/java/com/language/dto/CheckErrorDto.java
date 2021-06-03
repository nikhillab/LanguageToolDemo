package com.language.dto;

import java.util.List;


public class CheckErrorDto  {
    public int fromPos;
    public int toPos;
    public String message;
    public List<String> suggestion;

    public CheckErrorDto() {
    }

    public CheckErrorDto(int fromPos, int toPos, String message, List<String> suggestion) {
        this.fromPos = fromPos;
        this.toPos = toPos;
        this.message = message;
        this.suggestion = suggestion;
    }

    @Override
    public String toString() {
        return "CheckErrorDto [fromPos=" + fromPos + ", message=" + message + ", suggestion=" + suggestion + ", toPos="
                + toPos + "]";
    }

    public int getFromPos() {
        return fromPos;
    }

    public void setFromPos(int fromPos) {
        this.fromPos = fromPos;
    }

    public int getToPos() {
        return toPos;
    }

    public void setToPos(int toPos) {
        this.toPos = toPos;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(List<String> suggestion) {
        this.suggestion = suggestion;
    }

}
