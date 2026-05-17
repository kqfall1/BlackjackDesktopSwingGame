package com.github.kqfall1.java.blackjackDesktopSwingGame.jcomponents;

import com.github.kqfall1.java.blackjackDesktopSwingGame.ui.UiActions;
import com.github.kqfall1.java.blackjackDesktopSwingGame.ui.UiConstants;
import com.github.kqfall1.java.frameworks.awt.AwtUtils;
import java.awt.*;
import java.util.Optional;
import javax.swing.*;

/**
 * Contains all {@code JButton} objects required by a {@code MainMenuJFrame}.
 *
 * @author kqfall1
 * @since 24/01/2026
 */
public final class MainMenuButtonJPanel extends JPanel
{
    public MainMenuButtonJPanel(UiActions uiActions)
    {
        final var creditsButton = new MainMenuJPanelJButton(uiActions.getCredits());
        final var exitButton = new MainMenuJPanelJButton(uiActions.getExit());
        final var newGameButton = new MainMenuJPanelJButton(uiActions.getNewGame());
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        add(new UiConstants.VerticalStrutJPanel(UiConstants.MARGIN_VERTICAL_SMALL_MULTIPLIER));
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(newGameButton);
        add(new UiConstants.VerticalStrutJPanel(UiConstants.MARGIN_VERTICAL_SMALL_MULTIPLIER));
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(creditsButton);
        add(new UiConstants.VerticalStrutJPanel(UiConstants.MARGIN_VERTICAL_SMALL_MULTIPLIER));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(exitButton);
    }

    @Override
    public void addNotify()
    {
        super.addNotify();
        SwingUtilities.invokeLater(() ->
        {
            for (Component jButton : AwtUtils.getNestedComponents(Optional.of(JButton.class), this))
            {
                jButton.setFont(new Font(
                    UiConstants.JBUTTON_LARGE_FONT_NAME,
                    Font.BOLD,
                    UiConstants.getSizeRelativeToDisplayBounds(this, 0, UiConstants.JBUTTON_LARGE_FONT_SIZE_MULTIPLIER).height
                ));
            }
            revalidate();
        });
    }

    private static class MainMenuJPanelJButton extends JButton
    {
        private MainMenuJPanelJButton(Action action)
        {
            super(action);
            setForeground(Color.BLACK);
        }

        @Override
        public Dimension getPreferredSize()
        {
            return UiConstants.getSizeRelativeToDisplayBounds(this, UiConstants.JBUTTON_LARGE_WIDTH_MULTIPLIER, UiConstants.JBUTTON_LARGE_HEIGHT_MULTIPLIER);
        }

        @Override
        public Dimension getMaximumSize()
        {
            return getPreferredSize();
        }
    }
}
