package net.dean.jraw.models;

import com.fasterxml.jackson.databind.JsonNode;
import net.dean.jraw.util.Dimension;
import net.dean.jraw.models.meta.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * Represents a subreddit as it is displayed in the multireddit data structure.
 */
public final class MultiSubreddit extends RedditObject {
    /**
     * Instantiates a new MultiSubreddit
     *
     * @param dataNode The node to parse data from
     */
    public MultiSubreddit(JsonNode dataNode) {
        super(dataNode);
    }

    // NOTE: Much of this class is undocumented because this part of the API is fairly new.

    @JsonProperty(nullable = true)
    public @Nullable String getIconImage() {
        return data("icon_img");
    }

    @JsonProperty(nullable = true)
    public @Nullable String getKeyColor() {
        return data("key_color");
    }

    @JsonProperty(nullable = true)
    public @Nullable String getHeaderImage() {
        return data("header_img");
    }

    /** Checks if the user is a moderator of this subreddit */
    @JsonProperty(nullable = true)
    public Boolean isUserModerator() {
        return data("user_is_moderator", Boolean.class);
    }

    /** Checks if the user is banned from this subreddit */
    @JsonProperty(nullable = true)
    public Boolean isUserBanned() {
        return data("user_is_banned", Boolean.class);
    }

    /** Checks if the user is an approved contributor of this subreddit */
    @JsonProperty(nullable = true)
    public Boolean isUserContributor() {
        return data("user_is_contributor", Boolean.class);
    }

    @JsonProperty(nullable = true)
    public @Nullable Dimension getHeaderSize() {
        return _getHeaderSize();
    }

    @JsonProperty(nullable = true)
    public @Nullable Dimension getIconSize() {
        return _getDimension("icon_size");
    }

    /** Gets this subreddit's fullname (ex: "t5_2qh33") */
    @JsonProperty(nullable = true)
    public @Nullable String getFullName() {
        return data("fullname");
    }

    /** Gets this subreddit's human-readable name (ex: "funny") */
    @JsonProperty
    public @Nullable String getDisplayName() {
        return data("name");
    }
}
