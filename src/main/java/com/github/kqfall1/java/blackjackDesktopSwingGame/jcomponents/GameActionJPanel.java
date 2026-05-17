package com.github.kqfall1.java.blackjackDesktopSwingGame.jcomponents;

import com.github.kqfall1.java.blackjackDesktopSwingGame.ui.UiConstants;
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
    private final JButton doubleDownJButton;
    private final JButton hitJButton;
    private final Component largeStrut;
    private final JButton splitJButton;
    private final JButton standJButton;
    private final JButton surrenderJButton;

    public GameActionJPanel(Action doubleDown, Action hit, Action split, Action stand, Action surrender)
    {
        doubleDownJButton = new JButton(doubleDown);
        doubleDownJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        hitJButton = new JButton(hit);
        hitJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        largeStrut = Box.createVerticalStrut(0);
        splitJButton = new JButton(split);
        splitJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        standJButton = new JButton(stand);
        standJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        surrenderJButton = new JButton(surrender);
        surrenderJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(largeStrut);
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

    @Override
    public void addNotify()
    {
        super.addNotify();
        SwingUtilities.invokeLater(() ->
        {
            largeStrut.setPreferredSize(UiConstants.getSizeRelativeToDisplayBounds(largeStrut, 0, UiConstants.MARGIN_VERTICAL_LARGE_MUTIPLIER));
            revalidate();
        });
    }

    public JButton getDoubleDownJButton()
    {
        return doubleDownJButton;
    }

    public JButton getHitJButton()
    {
        return hitJButton;
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
}
