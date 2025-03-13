package net.dean.jraw.paginators;

import net.dean.jraw.paginators.UserContributionPaginator;
import net.dean.jraw.RedditClient;

public class UserProfilePaginator extends UserContributionPaginator {
    public UserProfilePaginator(RedditClient creator, String where, String username) {
        super(creator, where, username);
    }

    @Override
    protected String getSortingString() {
        if (sorting == null) return null;
        return sorting.name().toLowerCase();
    }
}
