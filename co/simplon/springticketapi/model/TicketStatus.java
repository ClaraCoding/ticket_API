package co.simplon.springticketapi.model;

import java.time.LocalDateTime;

public class TicketStatus { // objectif = suivi de la clôture des tickets dans une table dédiée
    private boolean isClosed;
    private LocalDateTime endTime;

    public TicketStatus(boolean isClosed, LocalDateTime endTime) {
        this.isClosed = isClosed;
        this.endTime = endTime;
    }
}
