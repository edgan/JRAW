package net.dean.jraw.models;

import com.fasterxml.jackson.databind.JsonNode;

import net.dean.jraw.models.attr.Created;

import java.util.Date;
import org.jspecify.annotations.Nullable;

/**
 * Class implementing a basic Subreddit Rule
 */
public class SubredditRule extends JsonModel implements Created {

    /**
     * Instantiates a new SubredditRule
     *
     * @param dataNode The node to parse data from
     */
    public SubredditRule(JsonNode dataNode) {
        super(dataNode);
    }

    /**
     * Gets when the object was created
     * @return Date created in local time
     */
    @Override
    public Date getCreated() {
        return new Date(getDataNode().get("created_utc").longValue() * 1000);
    }

    /**
     * Gets the kind of rule, "link", "comment", or "all"
     *
     * @return The kind of rule
     */
    public @Nullable RuleKind getKind() {
        // A rule with no "kind" is not one of the three below, which is what the trailing null
        // already reports; reading the absent key without this test threw instead.
        if (!getDataNode().hasNonNull("kind")) {
            return null;
        }
        switch (getDataNode().get("kind").asText()) {
            case "link":
                return RuleKind.LINK;
            case "comment":
                return RuleKind.COMMENT;
            case "all":
                return RuleKind.ALL;
        }
        return null;
    }

    /**
     * Markdown-formatted description of the rule
     *
     * @return Description
     */
    public String getDescription() {
        return getDataNode().get("description").asText();
    }

    /**
     * Gets the title for a rule
     * @return The rule's name
     */
    public String getShortName() {
        return getDataNode().get("short_name").asText();
    }

    /**
     * Gets the violation reason, aka report reason for the rule
     * @return The rule's violation reason
     */
    public String getViolationReason() {
        return getDataNode().get("violation_reason").asText();
    }

    public enum RuleKind {
        LINK,
        COMMENT,
        ALL
    }
}
