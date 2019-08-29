import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

class Engine implements Runnable {
    private EntityManager em;

    Engine(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public void run() {
        //this._02_RemoveObjects();
        //this._03_ContainsEmployee();
        //this._04_EmployeesWithSalaryOver50000();
        //this._05_EmployeesFromDepartment();
        //this._06_AddAddressAndUpdateEmployee();

    }

    private void _02_RemoveObjects() {
        this.em.getTransaction().begin();
        List<Town> towns = this.em
                .createQuery("FROM Town t WHERE LENGTH(t.name) > 5", Town.class)
                .getResultList();
        towns.forEach(t -> this.em.detach(t));
        towns.forEach(t -> {
            t.setName(t.getName().toLowerCase());
            this.em.merge(t);
        });
        this.em.getTransaction().commit();
    }

    private void _03_ContainsEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee name: ");
        String fullName = scanner.nextLine();
        this.em.getTransaction().begin();
        try {
            Employee employee = this.em
                    .createQuery("FROM Employee WHERE CONCAT(firstName,' ',lastName)=:fullName",
                            Employee.class)
                    .setParameter("fullName", fullName)
                    .getSingleResult();
            System.out.println("Yes");
        } catch (Exception e) {
            System.out.println("No");
        }
        this.em.getTransaction().commit();
    }

    private void _04_EmployeesWithSalaryOver50000() {
        this.em.getTransaction().begin();
        List<String> employeesFirstNames = this.em
                .createQuery("SELECT e.firstName FROM Employee e WHERE e.salary > 50000", String.class)
                .getResultList();
        employeesFirstNames.forEach(System.out::println);
        this.em.getTransaction().commit();
    }

    private void _05_EmployeesFromDepartment() {
        this.em.getTransaction().begin();
        List<Employee> employees = this.em
                .createQuery("FROM Employee AS e " +
                                 "WHERE e.department.name ='Research and Development' " +
                                 "ORDER BY e.salary, e.id",
                        Employee.class)
                .getResultList();
        employees.forEach(e -> System.out.printf("%s %s from %s - $%.2f\n",
                e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));
        this.em.getTransaction().commit();
    }

    private void _06_AddAddressAndUpdateEmployee() {
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        this.em.getTransaction().begin();
        Town town = this.em
                .createQuery("FROM Town WHERE id=32", Town.class)
                .getSingleResult();
        Address address = new Address();
        address.setText("Vitoshka 16");
        address.setTown(town);
        this.em.persist(address);
        this.em.getTransaction().commit();

        this.em.getTransaction().begin();
        try {
            Employee employee = this.em
                    .createQuery("FROM Employee WHERE lastName=:lastName", Employee.class)
                    .setParameter("lastName", lastName)
                    .getSingleResult();
            employee.setAddress(address);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.em.getTransaction().commit();

    }

}

