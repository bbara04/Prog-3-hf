package Amoba;

public class GameEndException extends Exception{
    private String text = new String();
    GameEndException(String winOrLose, String player, String reason){
        text += player;
        text += " ";
        text += winOrLose;
        text += ", mivel ";
        text += reason;
    }

    public String getText() {
        return text;
    }
}
