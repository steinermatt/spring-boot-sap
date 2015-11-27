package com.mlesniak.sap.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Simple service layer.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
@Service
public class TextService {
    @Autowired
    private TextRepository textRepository;

    public Long save(String text) {
        TextEntry textEntry = new TextEntry();
        textEntry.setText(text);
        textRepository.save(textEntry);
        return textEntry.getId();
    }

    public Iterable<TextEntry> list() {
        return textRepository.findAll();
    }

    public TextEntry get(Long id) {
        return textRepository.findOne(id);
    }
}
