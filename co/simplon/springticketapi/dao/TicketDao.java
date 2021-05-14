package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.controller.LearnerController;
import co.simplon.springticketapi.model.Learner;
import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.time.LocalDateTime;
import java.util.List;

@Component // **sens de l'annotation à creuser**
public class TicketDao implements Dao<Ticket> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Ticket> ticketRowMapper;

    public TicketDao(JdbcTemplate jdbcTemplate, RowMapper<Ticket> ticketRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.ticketRowMapper = ticketRowMapper;
    }

    @Override
    public Ticket get(Long id) { //OK - aller chercher un ticket dans la BDD avec son id
        return jdbcTemplate.queryForObject("select * from ticket where id = ?", ticketRowMapper, id);
    }

    @Override //OK - aller chercher tous les tickets dans la BDD
    public List<Ticket> getAll() {
        return jdbcTemplate.query("select * from ticket", ticketRowMapper);
    }

    @Override //OK - enregistrer un ticket dans la BDD
    // génération auto id & date dans la bdd + insertion description et l'id de l'apprenant provenant de la page web
    public void save(Ticket ticket) {
        jdbcTemplate.update("INSERT INTO ticket (id, date, description, learner_idx) VALUES (DEFAULT, NOW(), ?, ?)", ticket.getDescription(), ticket.getLearnerId());
    }

    //enregistrement de la fin du ticket
    public void finish(Long id) {
        jdbcTemplate.update("INSERT INTO ticketStatus (ticket_idx, isClosed, date_end) VALUES (? , TRUE, NOW())", id);
    }

    @Override // TODO supprimer un ticket dans la BDD
    public void delete(Long id) {
        // A vous de jouer
    }
}
