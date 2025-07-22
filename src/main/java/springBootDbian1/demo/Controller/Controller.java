package springBootDbian1.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import springBootDbian1.demo.Repository.RepositoryTaches;
import springBootDbian1.demo.model.Taches;
import springBootDbian1.demo.model.TachesNotFoundException;



@RestController
@RequestMapping(path="Taches")
@CrossOrigin
public class Controller {

    RepositoryTaches repository;

    public Controller(RepositoryTaches repository){
        this.repository = repository;
    }



    @PostMapping(consumes="application/json")
    public Taches newTaches(@Valid  @RequestBody Taches tache) {
        return this.repository.save(tache);
    }

    @GetMapping()
    public List<Taches> getAllTask() {
        return this.repository.findAll();
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Taches> getTache(@PathVariable int id){
        Optional<Taches> uneTache = this.repository.findById(id);

        // uneTache.map( valeur -> return  new ResponseEntity<>(null,HttpStatus.OK)).orElseThrow(
        //     ()->  new TachesNotFoundException("Pas de tache avecce nom")
        // ) ;

        if(uneTache.isPresent()){
            return new ResponseEntity<>(uneTache.get(),HttpStatus.OK) ;
        }
        throw  new TachesNotFoundException("Pas de tache avecce nom");
        // ) ;
        // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(path="/{id}")
    public boolean updateTask(@RequestBody Taches tache,@PathVariable int id){
        tache.setId(id);
        try{
            this.repository.save(tache);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @DeleteMapping
    public boolean deleteAll(){
        this.repository.deleteAll();
        return true;
    }

    @DeleteMapping(path="/delete/{id}")
    public boolean deleteTache(@PathVariable int id){
        Optional<Taches> uneTache = this.repository.findById(id);
        if(uneTache.isPresent()){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    @DeleteMapping(path="/{id}")
    public boolean finirTache(@PathVariable int id){
        Optional<Taches> uneTache = this.repository.findById(id);
        if(uneTache.isPresent()){
            this.repository.finirTache(id);
            return true;
        }
        return false;
    }

}
