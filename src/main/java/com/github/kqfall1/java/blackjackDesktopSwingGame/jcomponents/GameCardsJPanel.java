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

    public GameCardsJPanel()
    {
        activePlayerHandJPanel = new JPanel();
        activePlayerHandJPanel.setLayout(new FlowLayout(FlowLayout.LEFT, UiConstants.MARGIN_HORIZONTAL_EXTRA_SMALL, UiConstants.MARGIN_VERTICAL_EXTRA_SMALL));
        activePlayerHandJPanel.setOpaque(false);
        dealerHandJPanel = new JPanel();
        dealerHandJPanel.setLayout(new FlowLayout(FlowLayout.LEFT, UiConstants.MARGIN_HORIZONTAL_EXTRA_SMALL, UiConstants.MARGIN_VERTICAL_EXTRA_SMALL));
        dealerHandJPanel.setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        add(new UiConstants.VerticalStrutJPanel(UiConstants.MARGIN_VERTICAL_SMALL_MULTIPLIER));
        add(dealerHandJPanel);
        add(new UiConstants.VerticalStrutJPanel(UiConstants.MARGIN_VERTICAL_LARGE_MULTIPLIER));
        add(activePlayerHandJPanel);
        add(new UiConstants.VerticalStrutJPanel(UiConstants.MARGIN_VERTICAL_SMALL_MULTIPLIER));
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
