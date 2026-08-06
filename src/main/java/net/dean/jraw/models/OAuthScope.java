package net.dean.jraw.models;

import com.fasterxml.jackson.databind.JsonNode;
import net.dean.jraw.models.meta.JsonProperty;
import org.jspecify.annotations.Nullable;

public class OAuthScope extends Thing {
    public OAuthScope(JsonNode dataNode) {
        super(dataNode);
    }

    @JsonProperty
    public @Nullable String getDescription() {
        return data("description");
    }
}
