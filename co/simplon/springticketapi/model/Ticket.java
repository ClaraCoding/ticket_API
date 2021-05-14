package co.simplon.springticketapi.model;

import java.time.LocalDateTime;

public class Ticket {
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private String description;
    private Long learnerId;

    public Ticket() {
    } // constructeur vide pour méthode saveTicket (ne fonctionne pas sinon)

    public Ticket(Long id, LocalDateTime start, String description, Long learnerId) {
        this.id = id;
        this.start = start;
        this.description = description;
        this.learnerId = learnerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(Long learnerId) {
        this.learnerId = learnerId;
    }
}
