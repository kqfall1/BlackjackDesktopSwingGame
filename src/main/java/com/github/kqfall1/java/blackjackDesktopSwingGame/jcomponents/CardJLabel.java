package com.github.kqfall1.java.blackjackDesktopSwingGame.jcomponents;

import com.github.kqfall1.java.blackjackDesktopSwingGame.ui.UiConstants;
import com.github.kqfall1.java.blackjackEngine.cards.Card;
import com.github.kqfall1.java.frameworks.awt.AwtUtils;
import com.github.kqfall1.java.utils.StringUtils;
import java.awt.*;
import javax.swing.*;

/**
 * A {@code JLabel} to hold an {@code ImageIcon} to render cards.
 *
 * @author kqfall1
 * @since 15/03/2026
 */
public final class CardJLabel extends JLabel
{
    private final Card card;
    private String resourceLookupString;
    private static final String RESOURCE_LOOKUP_STRING_PREFIX = "/images/cards/";

    public CardJLabel(Card card, boolean faceUp)
    {
        this.card = card;
        setOpaque(false);
        setResourceLookupString(faceUp);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return AwtUtils.getSizeRelativeToDisplayBounds(this, UiConstants.CARD_IMAGE_WIDTH_MULTIPLIER, UiConstants.CARD_IMAGE_HEIGHT_MULTIPLIER)
            .orElseGet(() -> new Dimension(UiConstants.CARD_DEFAULT_WIDTH, UiConstants.CARD_DEFAULT_HEIGHT));
    }

    public void render(boolean faceUp)
    {
        final var cardSize = getPreferredSize();
        if (resourceLookupString.contains(UiConstants.BACK_OF_CARD_IMAGE_FILE_NAME) && faceUp)
        {
            setResourceLookupString(true);
        }
        final var cardImage = new ImageIcon(CardJLabel.class.getResource(resourceLookupString)).getImage().getScaledInstance(
            cardSize.width,
            cardSize.height,
            Image.SCALE_SMOOTH
        );
        setIcon(new ImageIcon(cardImage));
    }

    private void setResourceLookupString(boolean faceUp)
    {
        if (faceUp)
        {
            resourceLookupString = String.format(
                "%s%s_of_%ss.png",
                RESOURCE_LOOKUP_STRING_PREFIX,
                StringUtils.normalizeLower(card.getRank().toString()),
                StringUtils.normalizeLower(card.getSuit().toString())
            );
        }
        else
        {
            resourceLookupString = String.format("%s%s", RESOURCE_LOOKUP_STRING_PREFIX, UiConstants.BACK_OF_CARD_IMAGE_FILE_NAME);
        }
    }
}
