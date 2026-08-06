package net.dean.jraw.paginators;

import net.dean.jraw.paginators.UserContributionPaginator;
import net.dean.jraw.RedditClient;
import org.jspecify.annotations.Nullable;

public class UserProfilePaginator extends UserContributionPaginator {
    public UserProfilePaginator(RedditClient creator, String where, String username) {
        super(creator, where, username);
    }

    @Override
    protected @Nullable String getSortingString() {
        if (sorting == null) return null;
        return sorting.name().toLowerCase();
    }
}
