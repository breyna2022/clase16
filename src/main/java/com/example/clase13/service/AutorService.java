
package com.example.clase13.service;

import com.example.clase13.entity.Autor;
import java.util.List;

/**
 *
 * @author admin
 */
public interface AutorService {
    Autor create(Autor a);
    Autor update(Autor a);
    void delete(int id);
    Autor read(int id);
    List<Autor> readAll();
}
