package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.AddECommand;
import seedu.address.logic.commands.AddRCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.ConnectCommand;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteECommand;
import seedu.address.logic.commands.DeleteRCommand;
import seedu.address.logic.commands.DisconnectCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditECommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.ExportCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.FindECommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.HistoryCommand;
import seedu.address.logic.commands.ImportCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.ListECommand;
import seedu.address.logic.commands.ListFrCommand;
import seedu.address.logic.commands.ListRCommand;
import seedu.address.logic.commands.MeetCommand;
import seedu.address.logic.commands.PhotoCommand;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.SelectCommand;
import seedu.address.logic.commands.SwitchCommand;
import seedu.address.logic.commands.UndoCommand;

import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {
        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case AddECommand.COMMAND_WORD:
            return new AddECommandParser().parse(arguments);

        case AddRCommand.COMMAND_WORD:
            return new AddRCommandParser().parse(arguments);
        case ConnectCommand.COMMAND_WORD:
            return new ConnectCommandParser().parse(arguments);

        case DisconnectCommand.COMMAND_WORD:
            return new DisconnectCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case EditECommand.COMMAND_WORD:
            return new EditECommandParser().parse(arguments);

        case SelectCommand.COMMAND_WORD:
            return new SelectCommandParser().parse(arguments);

        case SwitchCommand.COMMAND_WORD:
            return new SwitchCommand();

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ExportCommand.COMMAND_WORD:
            return new ExportCommandParser().parse(arguments);

        case DeleteECommand.COMMAND_WORD:
            return new DeleteECommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case ImportCommand.COMMAND_WORD:
            return new ImportCommandParser().parse(arguments);

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case FindECommand.COMMAND_WORD:
            return new FindECommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ListECommand.COMMAND_WORD:
            return new ListECommand();

        case HistoryCommand.COMMAND_WORD:
            return new HistoryCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case UndoCommand.COMMAND_WORD:
            return new UndoCommand();

        case RedoCommand.COMMAND_WORD:
            return new RedoCommand();

        case MeetCommand.COMMAND_WORD:
            return new MeetCommandParser().parse(arguments);

        case PhotoCommand.COMMAND_WORD:
            return new PhotoCommand().parse(arguments);


        case DeleteRCommand.COMMAND_WORD:
            return new DeleteRCommandParser().parse(arguments);


        case ListFrCommand.COMMAND_WORD:
            return new ListFrCommand();

        case ListRCommand.COMMAND_WORD:
            return new ListRCommand();

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
