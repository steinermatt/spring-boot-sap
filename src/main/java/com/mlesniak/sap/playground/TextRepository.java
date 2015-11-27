package com.mlesniak.sap.playground;

import org.springframework.data.repository.CrudRepository;

/**
 * Default repository for text entries.
 *
 * @author Michael Lesniak (mlesniak@micromata.de)
 */
public interface TextRepository extends CrudRepository<TextEntry, Long> {
    // Empty
}
