package com.github.kqfall1.java.blackjackDesktopSwingGame.jcomponents;

import com.github.kqfall1.java.blackjackDesktopSwingGame.ui.UiActions;
import com.github.kqfall1.java.blackjackDesktopSwingGame.ui.UiConstants;
import com.github.kqfall1.java.frameworks.awt.AwtUtils;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        add(Box.createVerticalStrut(0));
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(newGameButton);
        add(Box.createVerticalStrut(0));
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(creditsButton);
        add(Box.createVerticalStrut(0));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(exitButton);
    }

    @Override
    public void addNotify()
    {
        super.addNotify();
        SwingUtilities.invokeLater(() ->
        {
            final var componentList = java.util.List.of(getComponents());
            final var smallStrutBounds = UiConstants.getSizeRelativeToDisplayBounds(this, 0, UiConstants.MARGIN_VERTICAL_SMALL_MULTIPLIER);

            for (Component component : AwtUtils.getNestedComponents(Optional.empty(), this))
            {
                if (component instanceof JButton jButton)
                {
                    jButton.setFont(new Font(
                        UiConstants.JBUTTON_LARGE_FONT_NAME,
                        Font.BOLD,
                        UiConstants.getSizeRelativeToDisplayBounds(this, 0, UiConstants.JBUTTON_LARGE_FONT_SIZE_MULTIPLIER).height
                    ));
                }
                else
                {
                    final var componentIndex = componentList.indexOf(component);
                    remove(component);
                    add(Box.createVerticalStrut(smallStrutBounds.height), componentIndex);
                }
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
