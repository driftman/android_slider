package ma.nse.sliderapp.beans;

/**
 * Created by admin on 16/07/2016.
 */
public class Interaction {

    private Long id;
    private Long nbPositiveReactions;
    private Long nbNegativeReactions;
    private Boolean myPositiveReaction;
    private Boolean myNegativeReaction;

    public Interaction() {
    }

    public Interaction(Long id, Boolean myNegativeReaction, Boolean myPositiveReaction, Long nbNegativeReactions, Long nbPositiveReactions) {
        this.id = id;
        this.myNegativeReaction = myNegativeReaction;
        this.myPositiveReaction = myPositiveReaction;
        this.nbNegativeReactions = nbNegativeReactions;
        this.nbPositiveReactions = nbPositiveReactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNbPositiveReactions() {
        return nbPositiveReactions;
    }

    public void setNbPositiveReactions(Long nbPositiveReactions) {
        this.nbPositiveReactions = nbPositiveReactions;
    }

    public Long getNbNegativeReactions() {
        return nbNegativeReactions;
    }

    public void setNbNegativeReactions(Long nbNegativeReactions) {
        this.nbNegativeReactions = nbNegativeReactions;
    }

    public Boolean getMyPositiveReaction() {
        return myPositiveReaction;
    }

    public void setMyPositiveReaction(Boolean myPositiveReaction) {
        this.myPositiveReaction = myPositiveReaction;
    }

    public Boolean getMyNegativeReaction() {
        return myNegativeReaction;
    }

    public void setMyNegativeReaction(Boolean myNegativeReaction) {
        this.myNegativeReaction = myNegativeReaction;
    }
}
