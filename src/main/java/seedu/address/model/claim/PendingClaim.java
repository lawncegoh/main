package seedu.address.model.claim;

import seedu.address.model.commonvariables.Date;
import seedu.address.model.commonvariables.Name;
import seedu.address.model.commonvariables.Phone;
import seedu.address.model.tag.Tag;

import java.util.Set;

public class PendingClaim extends Claim {

    private static final Status status = Status.PENDING;

    public PendingClaim(Description description, Amount amount, Date date, Name name, Phone phone, Set<Tag> tags) {
        super(description, amount, date, name, phone, tags, status);
    }

    @Override
    public boolean canChangeStatus() {
        return true;
    }

    /**
     * Returns true if both claims have same identity and data fields.
     * This defines a stronger notion of equality between two claims.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof PendingClaim)) {
            return false;
        }

        PendingClaim otherClaim = (PendingClaim) obj;
        return otherClaim.getDescription().equals(getDescription())
                && otherClaim.getName().equals(getName())
                && otherClaim.getDate().equals(getDate())
                && otherClaim.getPhone().equals(getPhone())
                && otherClaim.getAmount().equals(getAmount())
                && otherClaim.getTags().equals(getTags());
    }
}