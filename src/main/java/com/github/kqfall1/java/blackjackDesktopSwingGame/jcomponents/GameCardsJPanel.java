package com.github.kqfall1.java.blackjackDesktopSwingGame.jcomponents;

import com.github.kqfall1.java.blackjackDesktopSwingGame.ui.UiConstants;
import java.awt.*;
import javax.swing.*;

/**
 * Contains two {@code JPanel} objects to display cards to the {@code Player} actor.
 *
 * @author kqfall1
 * @since 07/03/2025
 */
public final class GameCardsJPanel extends JPanel
{
    private final JPanel activePlayerHandJPanel;
    private final JPanel dealerHandJPanel;
    private final Component largeStrut;
    private final Component smallStrut1;
    private final Component smallStrut2;

    public GameCardsJPanel()
    {
        activePlayerHandJPanel = new JPanel();
        activePlayerHandJPanel.setLayout(new FlowLayout(FlowLayout.LEFT, UiConstants.MARGIN_HORIZONTAL_EXTRA_SMALL, UiConstants.MARGIN_VERTICAL_EXTRA_SMALL));
        activePlayerHandJPanel.setOpaque(false);
        dealerHandJPanel = new JPanel();
        dealerHandJPanel.setLayout(new FlowLayout(FlowLayout.LEFT, UiConstants.MARGIN_HORIZONTAL_EXTRA_SMALL, UiConstants.MARGIN_VERTICAL_EXTRA_SMALL));
        dealerHandJPanel.setOpaque(false);
        largeStrut = Box.createVerticalStrut(0);
        smallStrut1 = Box.createVerticalStrut(0);
        smallStrut2 = Box.createVerticalStrut(0);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        add(smallStrut1);
        add(dealerHandJPanel);
        add(largeStrut);
        add(activePlayerHandJPanel);
        add(smallStrut2);
    }

    @Override
    public void addNotify()
    {
        super.addNotify();
        final var smallStrutBounds = UiConstants.getSizeRelativeToDisplayBounds(smallStrut1, 0, UiConstants.MARGIN_VERTICAL_SMALL_MULTIPLIER);
        SwingUtilities.invokeLater(() ->
        {
            largeStrut.setPreferredSize(UiConstants.getSizeRelativeToDisplayBounds(largeStrut, 0, UiConstants.MARGIN_VERTICAL_LARGE_MUTIPLIER));
            smallStrut1.setPreferredSize(smallStrutBounds);
            smallStrut2.setPreferredSize(smallStrutBounds);
            revalidate();
        });
    }

    public JPanel getActivePlayerHandJPanel()
    {
        return activePlayerHandJPanel;
    }

    public JPanel getDealerHandJPanel()
    {
        return dealerHandJPanel;
    }
}
