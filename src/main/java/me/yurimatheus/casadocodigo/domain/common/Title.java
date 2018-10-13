package me.yurimatheus.casadocodigo.domain.common;

import javax.persistence.Embeddable;

@Embeddable
public class Title {

    private String title;
    private String subtitle;

    public Title(String title, String subtite) {
        this.title = title;
        this.subtitle = subtite;
    }

    Title() {}

    public String getTitle() {
        return title;
    }

    public String getSubtite() {
        return subtitle;
    }
}
