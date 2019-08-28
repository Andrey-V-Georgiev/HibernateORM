import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.Scanner;

class Engine implements Runnable {
    private EntityManager entityManager;

    Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void run() {
        //this.containsEmployee();
        addAddressAndUpdateEmployee();
    }

    private void addAddressAndUpdateEmployee() {
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        this.entityManager.getTransaction().begin();
        Town town = this.entityManager
                .createQuery("FROM Town WHERE id=32", Town.class)
                .getSingleResult();
        Address address = new Address();
        address.setText("Vitoshka 17");
        address.setTown(town);
        this.entityManager.persist(address);
        this.entityManager.getTransaction().commit();

        this.entityManager.getTransaction().begin();
        Employee employee = this.entityManager
                .createQuery("FROM Employee WHERE lastName=:lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getSingleResult();
        employee.setAddress(address);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
    }


    private void containsEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee name: ");
        String fullName = scanner.nextLine();
        this.entityManager.getTransaction().begin();
        try {
            Employee employee = this.entityManager
                    .createQuery("FROM Employee WHERE CONCAT(firstName,' ',lastName)=:fullName",
                            Employee.class)
                    .setParameter("fullName", fullName)
                    .getSingleResult();
            System.out.println("Yes");
        } catch (Exception e) {
            System.out.println("No");
        }
        this.entityManager.getTransaction().commit();
    }
}

