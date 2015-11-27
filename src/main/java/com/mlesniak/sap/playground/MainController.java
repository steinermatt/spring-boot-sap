package com.mlesniak.sap.playground;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Example controller.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
@RestController
@RequestMapping("/rest")
public class MainController {
    @Autowired
    private TextRepository textRepository;

    @RequestMapping("/time")
    public String time() {
        return new Date().toString();
    }

    // TODO ML Use a dedicated service.
    // TODO ML Return correct HTTP status code.
    // TODO ML This should become a HTTP POST later; currently now solely GET for easier testing.
    @RequestMapping("/add")
    public String addEntry(@RequestParam("text") String text) {
        TextEntry textEntry = new TextEntry();
        textEntry.setText(text);
        textRepository.save(textEntry);
        return "OK";
    }

    // TODO ML This should become the root endpoint for this entity.
    @RequestMapping("/list")
    public Iterable<TextEntry> listEntries() {
        return textRepository.findAll();
    }
}

