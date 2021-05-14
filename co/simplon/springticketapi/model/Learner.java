package co.simplon.springticketapi.model;

public class Learner {

    // attributs des apprenants
    private final long id;
    private final String firstName;
//    private final String lastName;
//    private final String promoName; // pour faire des stats par promo
//    private final Long promoYear;

    // constructeur partiel
    public Learner(long id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    // constructeurs = ***utilisation à revoir...***
    //constructeur complet
//    public Learner(Long id, String firstName, String lastName, String promoName, Long promoYear) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.promoName = promoName;
//        this.promoYear = promoYear;
//    }


    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getPromoName() {
//        return promoName;
//    }
//
//    public Long getPromoYear() {
//        return promoYear;
//    }

//    @Override
//    public String toString() {
//        return "Apprenant#" + id +
//                " - " + firstName + '\'' +
//                " " + lastName + '\'' +
//                " - promo " + promoName + '\'' +
//                " " + promoYear;
//    }
}
