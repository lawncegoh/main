package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.RejectClaimCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ApproveClaimCommand object
 */
public class RejectClaimCommandParser implements Parser<RejectClaimCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ApproveClaimCommand
     * and returns a ApproveClaimCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public RejectClaimCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new RejectClaimCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, RejectClaimCommand.MESSAGE_USAGE), pe);
        }
    }

}
