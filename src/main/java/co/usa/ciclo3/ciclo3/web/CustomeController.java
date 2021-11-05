package co.usa.ciclo3.ciclo3.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import co.usa.ciclo3.ciclo3.model.Custome;
import co.usa.ciclo3.ciclo3.service.CustomeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/Custome")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CustomeController {
    
    @Autowired
    private CustomeService customeService;

    @GetMapping("/all")
    public List<Custome> getCustomes(){
        return customeService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Custome> getCustome(@PathVariable("id") int id){
        return customeService.getCustome(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Custome save(@RequestBody Custome c) {
        return customeService.save(c);
    }



    
}
