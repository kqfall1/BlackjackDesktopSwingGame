package com.github.kqfall1.java.blackjackDesktopSwingGame.jframes;

import com.github.kqfall1.java.blackjackDesktopSwingGame.ui.UiActions;
import com.github.kqfall1.java.blackjackDesktopSwingGame.ui.UiConstants;
import static com.github.kqfall1.java.blackjackDesktopSwingGame.ui.UiConstants.*;
import java.awt.*;
import javax.swing.*;

/**
 * Provides abstraction for the basic configuration of {@code JFrame} objects used for this blackjack app.
 *
 * @author kqfall1
 * @since 08/02/2026
 */
public abstract class BlackjackJFrame extends JFrame
{
    public BlackjackJFrame()
    {
        final var uiActions = UiActions.getInstance();
        final var background = new JPanel()
        {
            @Override
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(
                    UiConstants.JFRAME_BACKGROUND.getImage(),
                    0, 0,
                    getWidth(), getHeight(),
                    this
                );
            }
        };
        background.setLayout(new BorderLayout());
        setContentPane(background);
        setJMenuBar(new ApplicationJMenuBar(uiActions));
        uiActions.setKeystrokes(this);
        setTitle(BLACKJACK_JFRAME_TITLE);
    }

    @Override
    public void addNotify()
    {
        super.addNotify();
        final var displayBounds = getGraphicsConfiguration().getBounds();
        SwingUtilities.invokeLater(() ->
        {
            setIconImage(BLACKJACK_JFRAME_LOGO.getImage().getScaledInstance(ICON_HEIGHT_AND_WIDTH, ICON_HEIGHT_AND_WIDTH, Image.SCALE_SMOOTH));
            setSize(new Dimension(displayBounds.width, displayBounds.height));
            revalidate();
        });
    }

    private static class ApplicationJMenuBar extends JMenuBar
    {
        public ApplicationJMenuBar(UiActions uiActions)
        {
            final var gameMenu = new JMenu(UiConstants.JMENU_GAME_LABEL);
            gameMenu.add(uiActions.getExit());
            gameMenu.add(uiActions.getNewGame());
            gameMenu.add(uiActions.getMainMenu());
            gameMenu.add(uiActions.getCredits());
            add(gameMenu);
        }
    }
}
