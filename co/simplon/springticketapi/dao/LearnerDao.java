package co.simplon.springticketapi.dao;

import co.simplon.springticketapi.model.Learner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LearnerDao implements Dao<Learner> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Learner> learnerRowMapper;

    public LearnerDao(JdbcTemplate jdbcTemplate, RowMapper<Learner> learnerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.learnerRowMapper = learnerRowMapper;
    }

    @Override
    public Learner get(Long id) { // permet de chercher l'apprenant dans la BDD avec son id
        return jdbcTemplate.queryForObject("SELECT * FROM learner WHERE id = ?", learnerRowMapper, id);
    }

    @Override // permet de créér la liste des apprenants (learner) dans java
    public List<Learner> getAll() {
        return jdbcTemplate.query("select * from learner", learnerRowMapper);
    }


    @Override // TODO :p - à creuser...
    public void save(Learner learner) {
       //A vous de jouer
    }

    @Override
    public void delete(Long id) {
        // A vous de jouer
    }
}
