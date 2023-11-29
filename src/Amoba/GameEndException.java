package Amoba;

/**
 * Játék vége kivétel, ezt dobjuk amikor a játék végetért.
 */
public class GameEndException extends Exception{
    private String text = new String();
    GameEndException(String winOrLose, String player, String reason){
        text += player;
        text += " ";
        text += winOrLose;
        text += ", mivel ";
        text += reason;
    }

    /**
     * text getter-e
     * @return
     */
    public String getText() {
        return text;
    }
}
