package net.dean.jraw.models;

import net.dean.jraw.models.meta.JsonProperty;
import net.dean.jraw.models.meta.Model;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Date;
import org.jspecify.annotations.Nullable;

/** This class represents a reddit-hosted wiki page. */
@Model(kind = Model.Kind.WIKI_PAGE)
public final class WikiPage extends RedditObject {
    /** Instantiates a new WikiPage */
    public WikiPage(JsonNode dataNode) {
        super(dataNode);
    }

    /** Checks if the current user can edit this page */
    @JsonProperty
    public Boolean mayRevise() {
        return data("may_revise", Boolean.class);
    }

    /** Gets the date of last revision. If there have been no revisions, then the date of creation is returned. */
    @JsonProperty
    public @Nullable Date getRevisionDate() {
        return data("revision_date", Date.class);
    }

    /** Gets the content of this page */
    @JsonProperty
    public @Nullable String getContent() {
        return data("content_md");
    }

    /** Gets the person who last revised this page */
    @JsonProperty(nullable = true)
    public @Nullable Account getCurrentRevisionAuthor() {
        // hasNonNull rather than get(...).isNull(): a page with no revisions can omit the key
        // entirely, and get returns null for that rather than a NullNode.
        if (!data.hasNonNull("revision_by")) {
            return null;
        }
        // Same reason as the test above, one level down: an Account wrapping an absent "data"
        // child is non-null but throws from everything, so report it as no author instead.
        JsonNode author = data.get("revision_by").get("data");
        if (author == null || author.isNull()) {
            return null;
        }
        return new Account(author);
    }
}
