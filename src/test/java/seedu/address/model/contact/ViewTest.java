package seedu.address.model.contact;

import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.ViewException;
import seedu.address.model.View;

public class ViewTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new View(null, null));
    }

    @Test
    public void constructor_invalidName_throwsViewException() {
        String invalidView = "";
        assertThrows(ViewException.class, () -> new View(invalidView, 2));
    }

    @Test
    public void constructor_invalidIndex_throwsViewException() {
        int invalidIndex = 20;
        assertThrows(ViewException.class, () -> new View("contacts", invalidIndex));
    }
}
