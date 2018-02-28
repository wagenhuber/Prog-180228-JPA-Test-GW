package person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonService {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public PersonService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Person");
        entityManager = entityManagerFactory.createEntityManager();
    }


    public void savePerson(Person person) {
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }


    public static void main(String[] args) {
        PersonService personService = new PersonService();
        Person wagenhuber = new Person("wagenhuber");
        personService.savePerson(wagenhuber);


    }

}
