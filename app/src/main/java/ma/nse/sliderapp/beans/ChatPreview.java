package ma.nse.sliderapp.beans;

/**
 * Created by admin on 14/07/2016.
 */
public class ChatPreview {

    private String receiver;
    private Integer thumbnail;
    private String messageObject;
    private String messageContent;

    public ChatPreview() {
    }

    public ChatPreview(String receiver, String messageContent, String messageObject, Integer thumbnail) {
        this.receiver = receiver;
        this.messageContent = messageContent;
        this.messageObject = messageObject;
        this.thumbnail = thumbnail;
    }

    public String getMessageObject() {
        return messageObject;
    }

    public void setMessageObject(String messageObject) {
        this.messageObject = messageObject;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Integer getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Integer thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
