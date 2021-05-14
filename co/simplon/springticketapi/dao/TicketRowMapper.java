package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Ticket;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TicketRowMapper implements RowMapper<Ticket> {

    @Override // récupére le résultat ResultSet découpé par colonne/par ligne => ajout de toutes les colonnes
    public Ticket mapRow(ResultSet rs, int i) throws SQLException {
        return new Ticket(rs.getLong("id"), rs.getTimestamp("date").toLocalDateTime(), rs.getString ("description"), rs.getLong("learner_idx"));
    }
}
