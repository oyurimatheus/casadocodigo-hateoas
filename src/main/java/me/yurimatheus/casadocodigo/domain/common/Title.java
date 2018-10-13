package me.yurimatheus.casadocodigo.domain.common;

import javax.persistence.Embeddable;

@Embeddable
public class Title {

    private final String title;
    private final String subtite;

    public Title(String title, String subtite) {
        this.title = title;
        this.subtite = subtite;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtite() {
        return subtite;
    }
}
