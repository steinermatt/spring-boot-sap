package com.mlesniak.sap.playground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Simple service layer.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
@Service
public class TextService {
    private static final Logger LOG = LoggerFactory.getLogger(TextService.class);

    @Autowired
    private TextRepository textRepository;

    public Long save(String text) {
        LOG.info("Store text={}", text);
        TextEntry textEntry = new TextEntry();
        textEntry.setText(text);
        textRepository.save(textEntry);
        return textEntry.getId();
    }

    public Iterable<TextEntry> list() {
        LOG.info("List all entries");
        return textRepository.findAll();
    }

    public TextEntry get(Long id) {
        LOG.info("Get entry id={}", id);
        return textRepository.findOne(id);
    }
}
