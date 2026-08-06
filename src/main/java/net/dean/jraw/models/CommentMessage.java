package net.dean.jraw.models;

import net.dean.jraw.models.meta.JsonProperty;
import net.dean.jraw.models.meta.Model;
import com.fasterxml.jackson.databind.JsonNode;
import org.jspecify.annotations.Nullable;

/**
 * This class represents a message that appears in a user's inbox because another user has replied to his or her comment.
 */
@Model(kind = Model.Kind.COMMENT)
public final class CommentMessage extends Message {
    /**
     * Instantiates a new CommentMessage
     */
    public CommentMessage(JsonNode dataNode) {
        super(dataNode);
    }

    /** Gets the title of the link this comment was posted in */
    @JsonProperty
    public @Nullable String getLinkTitle() {
        return data("link_title");
    }

    /** Gets the way the logged in user voted on the comment that this message represents. */
    @JsonProperty(nullable = true)
    public VoteDirection getVote() {
        // Not @Nullable: every path below returns a VoteDirection. "likes" absent means the same
        // thing as "likes" null -- nobody voted -- and reading it without this test threw instead.
        JsonNode likes = getDataNode().get("likes");
        if (likes == null || likes.isNull()) {
            return VoteDirection.NO_VOTE;
        }

        return likes.booleanValue() ? VoteDirection.UPVOTE : VoteDirection.DOWNVOTE;
    }
}
