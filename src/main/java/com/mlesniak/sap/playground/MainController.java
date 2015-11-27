package com.mlesniak.sap.playground;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Example controller.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
@RestController
@RequestMapping("/rest/text")
public class MainController {
    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private TextService textService;

    @Autowired
    private DataSource dataSource;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Long> save(@RequestParam("text") String text) {
        Long id = textService.save(text);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @RequestMapping("")
    public Iterable<TextEntry> find() {
        LOG.error("ds:{}", dataSource);
        return textService.list();
    }

    @RequestMapping("/{id}")
    public String get(@PathVariable("id") Long id) {
        return textService.get(id).getText();
    }
}

