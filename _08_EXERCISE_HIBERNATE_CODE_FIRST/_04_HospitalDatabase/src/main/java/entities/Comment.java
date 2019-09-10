package entities;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    private CommentContent commentContent;

    public Comment() {
    }

    @ManyToOne()
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    public CommentContent getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(CommentContent commentContent) {
        this.commentContent = commentContent;
    }
}
