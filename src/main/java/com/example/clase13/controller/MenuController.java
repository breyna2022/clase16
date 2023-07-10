
package com.example.clase13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @GetMapping("/editorial")
    public String index(){
        return "editorial/editorial";
    }
}
