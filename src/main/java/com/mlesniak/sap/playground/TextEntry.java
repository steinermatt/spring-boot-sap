package com.mlesniak.sap.playground;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Example entity.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
@Entity
public class TextEntry {
    @Id
    @GeneratedValue
    private Long id;

    private String text;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextEntry{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
