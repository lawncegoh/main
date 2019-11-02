package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.SortFilter;
import seedu.address.ui.UiManager;

/**
 * Sorts the current list in normal order
 */
//@@author {lawncegoh}
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_SUCCESS_CONTACTS = "Contacts List Sorted in Lexicographical Order";

    public static final String MESSAGE_SUCCESS_CLAIMS = "Claims List Sorted in Lexicographical Order";

    public static final String MESSAGE_SUCCESS_INCOMES = "Incomes List Sorted in Lexicographical Order";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + "sorts the current list in lexicographical";

    public static final String MESSAGE_FAILURE = "Sort doesn't work here";

    public static final String MESSAGE_FAILURE_FILTER = "Filter does not exist";

    public static final String MESSAGE_FAILURE_FILTER_DATE = "Date filter is not valid for contacts";

    private static final String MESSAGE_SUCCESS_CLAIMS_DATE = "Claims list sorted from Oldest Entry to Newest";

    private static final String MESSAGE_SUCCESS_INCOMES_DATE = "Incomes list sorted from Oldest Entry to Newest";

    private SortFilter gotoFilter;

    /**
     * Constructs a sort command
     *
     * @param sortFilter 2 different types of filters
     * @return
     * @throws CommandException
     */
    public SortCommand(SortFilter sortFilter) {
        requireNonNull(sortFilter);
        try {
            if (sortFilter == null) {
                throw new ParseException("error");
            }
            gotoFilter = sortFilter;
        } catch (ParseException e) {
            e.getMessage();
        }
    }

    /**
     * Execute method to determine the right filter to go to
     *
     * @param model {@code Model} which the command should operate on.
     * @return a CommandResult after updating the model
     * @throws CommandException
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        switch (gotoFilter.getIndex()) {

        case 1: //case of sorting by name

            if (UiManager.getState().equals("contacts")) {
                model.sortFilteredContactListByName();
                return new CommandResult(MESSAGE_SUCCESS_CONTACTS, false, false, false, false, false);
            } else if (UiManager.getState().equals("claims")) {
                model.sortFilteredClaimListByName();
                return new CommandResult(MESSAGE_SUCCESS_CLAIMS, false, false, false, false, false);
            } else if (UiManager.getState().equals("incomes")) {
                model.sortFilteredIncomeListByName();
                return new CommandResult(MESSAGE_SUCCESS_INCOMES, false, false, false, false, false);
            } else {
                throw new CommandException(MESSAGE_FAILURE);
            }

        case 2: //case of sorting by date

            if (UiManager.getState().equals("claims")) {
                model.sortFilteredClaimListByDate();
                return new CommandResult(MESSAGE_SUCCESS_CLAIMS_DATE, false, false, false, false, false);
            } else if (UiManager.getState().equals(("incomes"))) {
                model.sortFilteredIncomeListByDate();
                return new CommandResult(MESSAGE_SUCCESS_INCOMES_DATE, false, false, false, false, false);
            } else {
                throw new CommandException(MESSAGE_FAILURE_FILTER_DATE);
            }

        default:
            throw new CommandException(MESSAGE_FAILURE_FILTER);

        }
    }

    //    @Override
    //    public boolean equals(Object other) {
    //        if (gotoFilter.equals(((SortCommand) other).gotoFilter)) {
    //            return true;
    //        } else {
    //            return false;
    //        }
    //    }
}


