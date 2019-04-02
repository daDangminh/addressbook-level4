package seedu.address.model.event;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Event}'s {@code venue} matches any of the keywords given.
 */
public class VenueContainsKeywordsPredicate implements Predicate<Event> {
    private final List<String> keywords;

    public VenueContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Event event) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(event.getVenue().value, keyword));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof VenueContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((VenueContainsKeywordsPredicate) other).keywords)); // state check
    }

}
