
package com.example.clase13.repository;


import com.example.clase13.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer>{
    
}
