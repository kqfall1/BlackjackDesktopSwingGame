package com.github.kqfall1.java.blackjackDesktopSwingGame.jcomponents;

import com.github.kqfall1.java.blackjackDesktopSwingGame.ui.UiConstants;
import com.github.kqfall1.java.frameworks.awt.AwtUtils;
import com.github.kqfall1.java.frameworks.awt.VerticalStrutJPanel;
import java.awt.*;
import javax.swing.*;

/**
 * Contains all {@code JComponent} objects required to perform core blackjack actions.
 *
 * @author kqfall1
 * @since 03/03/2026
 */
public class GameActionJPanel extends JPanel
{
    private final GameActionJButton doubleDownJButton;
    private final GameActionJButton hitJButton;
    private final GameActionJButton splitJButton;
    private final GameActionJButton standJButton;
    private final GameActionJButton surrenderJButton;

    public GameActionJPanel(Action doubleDown, Action hit, Action split, Action stand, Action surrender)
    {
        doubleDownJButton = new GameActionJButton(doubleDown);
        doubleDownJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        hitJButton = new GameActionJButton(hit);
        hitJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        splitJButton = new GameActionJButton(split);
        splitJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        standJButton = new GameActionJButton(stand);
        standJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        surrenderJButton = new GameActionJButton(surrender);
        surrenderJButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new VerticalStrutJPanel(UiConstants.MARGIN_VERTICAL_SMALL_MULTIPLIER));
        add(doubleDownJButton);
        add(Box.createVerticalStrut(UiConstants.MARGIN_VERTICAL_EXTRA_SMALL));
        add(hitJButton);
        add(Box.createVerticalStrut(UiConstants.MARGIN_VERTICAL_EXTRA_SMALL));
        add(splitJButton);
        add(Box.createVerticalStrut(UiConstants.MARGIN_VERTICAL_EXTRA_SMALL));
        add(standJButton);
        add(Box.createVerticalStrut(UiConstants.MARGIN_VERTICAL_EXTRA_SMALL));
        add(surrenderJButton);
    }

    public JButton getDoubleDownJButton()
    {
        return doubleDownJButton;
    }

    public JButton getHitJButton()
    {
        return hitJButton;
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(
            getDoubleDownJButton().getPreferredSize().width + UiConstants.GAME_SIDEBAR_INSETS.left + UiConstants.GAME_SIDEBAR_INSETS.right,
            Integer.MAX_VALUE
        );
    }

    public JButton getSplitJButton()
    {
        return splitJButton;
    }

    public JButton getStandJButton()
    {
        return standJButton;
    }

    public JButton getSurrenderJButton()
    {
        return surrenderJButton;
    }

    private static final class GameActionJButton extends JButton
    {
        public GameActionJButton(Action action)
        {
            super(action);
        }

        @Override
        public Dimension getMaximumSize()
        {
            return getPreferredSize();
        }

        @Override
        public Dimension getPreferredSize()
        {
            return AwtUtils.getSizeRelativeToDisplayBounds(this, UiConstants.GAME_ACTION_JBUTTON_WIDTH_MULTIPLIER, UiConstants.GAME_ACTION_JBUTTON_HEIGHT_MULTIPLIER)
                .orElseGet(() -> new JButton(getText()).getPreferredSize());
        }
    }
}
