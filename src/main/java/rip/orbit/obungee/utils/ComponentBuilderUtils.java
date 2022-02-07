package rip.orbit.obungee.utils;

import net.md_5.bungee.api.chat.*;

public class ComponentBuilderUtils {
    public static BaseComponent[] buildHighlightedTextComponent(String text, String highlightedText) {
        return (new ComponentBuilder(CC.translate(text))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(CC.translate(highlightedText)))).create();
    }

    public static BaseComponent[] buildHighlightedTextComponentWithClickURL(String text, String highlightedText, String openUrl) {
        return (new ComponentBuilder(CC.translate(text))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(CC.translate(highlightedText)))).event(new ClickEvent(ClickEvent.Action.OPEN_URL, openUrl)).create();
    }

    public static BaseComponent[] buildHighlightedTextComponentWithClickCommand(String text, String highlightedText, String command) {
        return (new ComponentBuilder(CC.translate(text))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, TextComponent.fromLegacyText(CC.translate(highlightedText)))).event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command)).create();
    }
}
