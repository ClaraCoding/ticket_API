package co.simplon.springticketapi.controller;

import co.simplon.springticketapi.dao.TicketDao;
import co.simplon.springticketapi.model.Ticket;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/tickets")
@RestController
public class TicketController {

    private final TicketDao ticketDao;

    public TicketController(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketDao.getAll();
    }

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable Long id) {
        return ticketDao.get(id);
    }


    // methode post qui utilise la methode save de ticketDao pour enregistrer le ticket
    //la méthode post permet de sauvegarder une entrée web sous forme d'objet java pour réutiliser dans le code de l'API
    @PostMapping
    public void saveTicket(@RequestBody Ticket ticket, @RequestParam(value = "description") String description, @RequestParam(value = "learnerId") Long learnerIdx) { // prendre ce qui est dans le corps de la requête
        ticket.setLearnerId(learnerIdx); // enregistrement de la saisie dans swagger
        ticket.setDescription(description); // enregistrement de la saisie dans swagger
        ticketDao.save(ticket);
    }

    //  end_ticket = Màj du ticket lorsqu'il est fini
    @PostMapping("/{end}")
    public void endTicket(@RequestParam(value = "ticketId") Long id) {
        ticketDao.finish(id);
    }

}

