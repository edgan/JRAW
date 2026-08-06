package net.dean.jraw.models;

import net.dean.jraw.models.attr.Created;
import net.dean.jraw.models.meta.JsonProperty;
import net.dean.jraw.models.meta.Model;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Date;
import org.jspecify.annotations.Nullable;

/**
 * Represents an administrative action from a moderator of a subreddit
 */
@Model(kind = Model.Kind.MOD_ACTION)
public final class ModAction extends Thing implements Created {
    /** Instantiates a new ModAction */
    public ModAction(JsonNode dataNode) {
        super(dataNode);
    }

    /** Gets the action's description. May be null if the action is generic such as "sticky" or "unsticky" */
    @JsonProperty(nullable = true)
    public @Nullable String getDescription() {
        return data("description");
    }

    /**
     * The moderator's ID (not their username)
     *
     * @see #getModerator()
     */
    @JsonProperty
    public @Nullable String getModeratorId() {
        return data("mod_id36");
    }

    /** The name of the moderator who did the action */
    @JsonProperty
    public @Nullable String getModerator() {
        return data("mod");
    }

    /**
     * The subreddit in which this action occurred. May be null.
     */
    @JsonProperty(nullable = true)
    public @Nullable String getSubreddit() {
        return data("subreddit");
    }

    /**
     * The permalink to the post in question. For example:
     * "/r/jraw_testing2/comments/2m2gnc/self_post_test_epoch1415796343364/"
     */
    @JsonProperty
    public @Nullable String getTargetPermalink() {
        return data("target_permalink");
    }

    /** Gets any extra details about the action. Will be an empty string if there are none. */
    @JsonProperty
    public @Nullable String getDetails() {
        return data("details");
    }

    /** Gets the action that was performed. For example, "sticky", "unsticky" */
    @JsonProperty
    public @Nullable String getAction() {
        return data("action");
    }

    /** The name of the author whose post was targeted */
    @JsonProperty
    public @Nullable String getTargetAuthor() {
        return data("jraw_test");
    }

    /** The username of the author whose post was targeted */
    @JsonProperty
    public @Nullable String getTargetFullName() {
        return data("target_fullname");
    }

    /** The subreddit's ID in which this action occurred. For example, "31qvo" */
    @JsonProperty
    public @Nullable String getSubredditId() {
        return data("sr_id36");
    }

    @Override
    public Date getCreated() {
        return _getCreated();
    }
}
