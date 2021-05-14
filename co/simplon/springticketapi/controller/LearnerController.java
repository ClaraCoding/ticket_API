package co.simplon.springticketapi.controller;


import co.simplon.springticketapi.dao.LearnerDao;
import co.simplon.springticketapi.model.Learner;
import co.simplon.springticketapi.model.Ticket;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/learners")
@RestController
public class LearnerController {

    private final LearnerDao learnerDao;

    public LearnerController(LearnerDao learnerDao) {
        this.learnerDao = learnerDao;
    }

    // N.B: url diff pour chaque get
    @GetMapping // OK - récuperer la liste des apprenants (pour l'afficher sur le site?)
    public List<Learner> getAllLearners() {
        return learnerDao.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET) // = autre écriture pour "GetMapping"
    public Learner getLearner(@RequestParam(value = "learnerId") Long id) { // récupérer un apprenant en fonction de son ID
        return learnerDao.get(id);
    }

    @PostMapping //TODO méthode post pour sauvegarder un nouvel apprenant dans la bdd
    public void saveLearner(@RequestBody Learner learner) { // prendre ce qui est dans le corps de la requête
        learnerDao.save(learner);
    }

}

