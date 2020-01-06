package com.javaexample.box;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
public class BoxController {

    @Autowired
    private BoxService boxService;

    @RequestMapping(
        value="/box",
        method=RequestMethod.POST,
        produces=MediaType.APPLICATION_JSON_VALUE
    )
    public Box Create(@RequestBody Box box){
        Box result = boxService.Create(box);
        return result;
    }

    @RequestMapping(
        value="/box",
        method=RequestMethod.GET,
        produces=MediaType.APPLICATION_JSON_VALUE
    )
    public Collection<Box>  List(){
        Collection<Box> result = boxService.List();
        return result;
    }
}
