
package com.example.clase13.service;


import com.example.clase13.entity.Editorial;
import java.util.List;

/**
 *
 * @author admin
 */
public interface EditorialService {
    Editorial create(Editorial editorial);
    Editorial update(Editorial editorial);
    void delete(int id);
    Editorial read(int id);
    List<Editorial> readAll();
}
