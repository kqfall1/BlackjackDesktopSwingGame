package com.github.kqfall1.java.blackjackDesktopSwingGame.jcomponents;

import com.github.kqfall1.java.blackjackDesktopSwingGame.ui.UiActions;
import com.github.kqfall1.java.blackjackDesktopSwingGame.ui.UiConstants;
import com.github.kqfall1.java.frameworks.awt.AwtUtils;
import com.github.kqfall1.java.frameworks.awt.VerticalStrutJPanel;
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
        add(new VerticalStrutJPanel(UiConstants.MARGIN_VERTICAL_SMALL_MULTIPLIER));
        newGameButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(newGameButton);
        add(new VerticalStrutJPanel(UiConstants.MARGIN_VERTICAL_SMALL_MULTIPLIER));
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(creditsButton);
        add(new VerticalStrutJPanel(UiConstants.MARGIN_VERTICAL_SMALL_MULTIPLIER));
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
                    AwtUtils.getSizeRelativeToDisplayBounds(this, 0, UiConstants.JBUTTON_LARGE_FONT_SIZE_MULTIPLIER)
                        .orElseGet(() -> new Dimension(0, UiConstants.MARGIN_VERTICAL_EXTRA_SMALL)).height
                ));
            }
            revalidate();
        });
    }

    private static final class MainMenuJPanelJButton extends JButton
    {
        private MainMenuJPanelJButton(Action action)
        {
            super(action);
            setForeground(Color.BLACK);
        }

        @Override
        public Dimension getMaximumSize()
        {
            return getPreferredSize();
        }

        @Override
        public Dimension getPreferredSize()
        {
            return AwtUtils.getSizeRelativeToDisplayBounds(this, UiConstants.JBUTTON_LARGE_WIDTH_MULTIPLIER, UiConstants.JBUTTON_LARGE_HEIGHT_MULTIPLIER)
                .orElseGet(() -> new Button(getText()).getPreferredSize());
        }
    }
}
