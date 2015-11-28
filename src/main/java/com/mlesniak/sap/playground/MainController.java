package com.mlesniak.sap.playground;

import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @ApiOperation("Stores a new text entry")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Long> save(@RequestBody String text) {
        LOG.debug("Request to POST:/");
        try {
            Long id = textService.save(text);
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation("Retrieve the list of all stored entries")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<TextEntry> find() {
        LOG.debug("Request to GET:/");
        return textService.list();
    }

    @ApiOperation("Retrieve a single entry for the given id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") Long id) {
        LOG.debug("Request to GET:/{}", id);
        return textService.get(id).getText();
    }
}

