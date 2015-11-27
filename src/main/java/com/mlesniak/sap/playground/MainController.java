package com.mlesniak.sap.playground;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Example controller.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
@RestController
@RequestMapping("/rest")
public class MainController {
    @RequestMapping("/time")
    public String time() {
        return new Date().toString();
    }

}

