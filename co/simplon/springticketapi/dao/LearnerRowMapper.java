package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Learner;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LearnerRowMapper implements RowMapper<Learner> {

    @Override // ****pour le moment, juste deux colonnes - Faut-il mettre toutes les colonnes de la table learner?****
    public Learner mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Learner(resultSet.getLong("id"), resultSet.getString("firstname"));
    }


}
