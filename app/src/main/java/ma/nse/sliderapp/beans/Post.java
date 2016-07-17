package ma.nse.sliderapp.beans;

import java.util.Date;

import ma.nse.sliderapp.beans.Interaction;

/**
 * Created by admin on 16/07/2016.
 */
public class Post {

    private Long id;
    private String owner;
    private String ownerThumbnail;
    private String title;
    private String content;
    private Date createdAt;
    private Interaction interactions;
    private String mainPictureLink;
    private String[] otherPicturesLinks;
    private String audioLink;

    public Post() {
    }

    public Post(String audioLink, String[] otherPicturesLinks, Interaction interactions,
                String mainPictureLink, Date createdAt, String content, String title,
                String ownerThumbnail, String owner, Long id) {
        this.audioLink = audioLink;
        this.otherPicturesLinks = otherPicturesLinks;
        this.interactions = interactions;
        this.mainPictureLink = mainPictureLink;
        this.createdAt = createdAt;
        this.content = content;
        this.title = title;
        this.ownerThumbnail = ownerThumbnail;
        this.owner = owner;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerThumbnail() {
        return ownerThumbnail;
    }

    public void setOwnerThumbnail(String ownerThumbnail) {
        this.ownerThumbnail = ownerThumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Interaction getInteractions() {
        return interactions;
    }

    public void setInteractions(Interaction interactions) {
        this.interactions = interactions;
    }

    public String getMainPictureLink() {
        return mainPictureLink;
    }

    public void setMainPictureLink(String mainPictureLink) {
        this.mainPictureLink = mainPictureLink;
    }

    public String[] getOtherPicturesLinks() {
        return otherPicturesLinks;
    }

    public void setOtherPicturesLinks(String[] otherPicturesLinks) {
        this.otherPicturesLinks = otherPicturesLinks;
    }

    public String getAudioLink() {
        return audioLink;
    }

    public void setAudioLink(String audioLink) {
        this.audioLink = audioLink;
    }
}
