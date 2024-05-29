package io.github.dlebedev.yatpoker;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Help.Visibility;

import io.github.dlebedev.yatpoker.GameType;
import io.github.dlebedev.yatpoker.PokerStyle;

@CommandLine.Command(
        name="PokerGame",
        description="@|bold Yet Another Poker Game |@",
        headerHeading="@|bold,underline Command Line Usage|@:%n%n",
        version = "0.0.1",
        sortSynopsis = false)
public class YATPoker {
    @Option(names = {"-s", "--style"}, description = "Poker style: ${COMPLETION-CANDIDATES}", showDefaultValue = Visibility.ALWAYS)
    private PokerStyle pokerStyle = PokerStyle.holdem;

    @Option(names = {"-t", "--type"}, description = "Game type: ${COMPLETION-CANDIDATES}", showDefaultValue = Visibility.ALWAYS)
    private GameType gameType = GameType.tournament;

    @Option(names = {"-l", "--limits"}, description = "Game limits type: ${COMPLETION-CANDIDATES}", showDefaultValue = Visibility.ALWAYS)
    private LimitType limitType = LimitType.nolimit;

    @Option(names = { "-V", "--version" }, description = "print version information and exit", versionHelp = true)
    private boolean versionRequested;

    @Option(names = {"-h", "--help"}, description = "Display help/usage.", usageHelp = true)
    private boolean help = false;

    @Parameters(index = "0", description = "Big blinds")
    private double big;

    @Parameters(index = "1", arity = "0..1", description = "Small blinds (usually Big blinds / 2)")
    private double small;

    @Parameters(index = "2", arity = "0..1", description = "Ante", defaultValue = "0.0", showDefaultValue = Visibility.ALWAYS)
    private double ante;

    public static PokerGame getPokerGame(GameType gameType) {
        return  gameType.getConstructor().get();
    }

    public static PokerStyleFactory getPokerStyleFactory(PokerStyle pokerStyle) {
        return  pokerStyle.getConstructor().get();
    }

    public static void main(String[] arguments) {
        CommandLine cmd = new CommandLine(new YATPoker()).setCaseInsensitiveEnumValuesAllowed(true);

        try {
            cmd.parseArgs(arguments);
        } catch (CommandLine.ParameterException ex) {
            cmd.getErr().println(ex.getMessage());
            if (!CommandLine.UnmatchedArgumentException.printSuggestions(ex, cmd.getErr())) {
                cmd.usage(cmd.getErr());
            }
            return;
        }

        if (cmd.isUsageHelpRequested()) {
            cmd.usage(cmd.getOut());
            return;
        }

        if (cmd.isVersionHelpRequested()) {
            cmd.printVersionHelp(cmd.getOut());
            return;
        }

        YATPoker app = cmd.getCommand();
        if (app.small == 0) app.small = app.big / 2;

        BettingStructure bettingStructure = new BettingStructure(app.big, app.small, app.ante, app.limitType);
        PokerStyleFactory factory = getPokerStyleFactory(app.pokerStyle);

        PokerGame pokerGame = getPokerGame(app.gameType);
        pokerGame.setBettingStructure(bettingStructure);
        pokerGame.setFactory(factory);
    }
}
