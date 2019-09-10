package entities;

import javax.persistence.*;
import java.util.Set;

@MappedSuperclass
public abstract class CommentKeeper extends BaseEntity {

    private Set<Comment> comments;

    public CommentKeeper() {
    }

    @OneToMany(targetEntity = Comment.class )
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
