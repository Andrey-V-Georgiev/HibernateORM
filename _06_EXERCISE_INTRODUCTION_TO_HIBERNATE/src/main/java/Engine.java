import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

class Engine implements Runnable {
    private EntityManager em;

    Engine(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public void run() {
        this._02_RemoveObjects();
//        this._03_ContainsEmployee();
//        this._04_EmployeesWithSalaryOver50000();
//        this._05_EmployeesFromDepartment();
//        this._06_AddAddressAndUpdateEmployee();
//        this._07_AddressesWithEmployeeCount();
//        this._08_GetEmployeeWithProject();
//        this._09_FindLatest10Projects();
//        this._10_getIncreaseSalaries();
    }


    private void _02_RemoveObjects() {
        this.em.getTransaction().begin();
        List<Town> towns = this.em
                .createQuery(new StringBuilder()
                        .append("FROM Town t WHERE LENGTH(t.name) > 5")
                        .toString(), Town.class)
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
                    .createQuery(new StringBuilder()
                                    .append("FROM Employee ")
                                    .append("WHERE CONCAT(firstName,' ',lastName)=:fullName")
                                    .toString()
                            , Employee.class)
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
                .createQuery(new StringBuilder()
                                .append("SELECT e.firstName ")
                                .append("FROM Employee e ")
                                .append("WHERE e.salary > 50000").toString()
                        , String.class)
                .getResultList();
        employeesFirstNames.forEach(System.out::println);
        this.em.getTransaction().commit();
    }

    private void _05_EmployeesFromDepartment() {
        this.em.getTransaction().begin();
        List<Employee> employees = this.em
                .createQuery(new StringBuilder()
                                .append("FROM Employee AS e ")
                                .append("WHERE e.department.name ='Research and Development' ")
                                .append("ORDER BY e.salary, e.id").toString(),
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
                .createQuery(new StringBuilder()
                        .append("FROM Town WHERE id=32")
                        .toString(), Town.class)
                .getSingleResult();
        Address address = new Address();
        address.setText("Vitoshka 16");
        address.setTown(town);
        this.em.persist(address);
        this.em.getTransaction().commit();

        this.em.getTransaction().begin();
        try {
            Employee employee = this.em
                    .createQuery(new StringBuilder()
                            .append("FROM Employee WHERE lastName=:lastName")
                            .toString(), Employee.class)
                    .setParameter("lastName", lastName)
                    .getSingleResult();
            employee.setAddress(address);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.em.getTransaction().commit();

    }

    private void _07_AddressesWithEmployeeCount() {
        this.em.getTransaction().begin();
        List<Address> addresses = this.em
                .createQuery(new StringBuilder()
                                .append("FROM Address AS a ")
                                .append("ORDER BY SIZE(a.employees) DESC, a.town.id ASC")
                                .toString()
                        , Address.class)
                .setMaxResults(10)
                .getResultList();
        addresses.forEach(a -> System.out.printf("%s, %S - %d employees\n",
                a.getText(), a.getTown().getName(), a.getEmployees().size()));

        this.em.getTransaction().commit();
    }

    private void _08_GetEmployeeWithProject() {
        Scanner scanner = new Scanner(System.in);
        int employeeId = Integer.parseInt(scanner.nextLine());

        this.em.getTransaction().begin();
        Employee employee = this.em
                .createQuery(new StringBuilder()
                                .append("FROM Employee as e ")
                                .append("WHERE e.id=:employeeId")
                                .toString()
                        , Employee.class)
                .setParameter("employeeId", employeeId)
                .getSingleResult();
        System.out.printf("%s %s - %s\n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());
        this.em.getTransaction().commit();

        this.em.getTransaction().begin();
        List<Project> projects = this.em
                .createQuery(new StringBuilder()
                                .append("FROM Project AS p ")
                                .append("WHERE :employee MEMBER OF p.employees ")
                                .append("ORDER BY p.name ASC")
                                .toString()
                        , Project.class)
                .setParameter("employee", employee)
                .getResultList();
        projects.forEach(p -> System.out.println("\t" + p.getName()));
        this.em.getTransaction().commit();

    }

    private void _09_FindLatest10Projects() {
        this.em.getTransaction().begin();
        List<Project> last10Projects = this.em
                .createQuery(new StringBuilder()
                                .append("FROM Project ")
                                .append("ORDER BY startDate DESC, name")
                                .toString()
                        , Project.class)
                .setMaxResults(10)
                .getResultList();
        this.em.getTransaction().commit();

        this.em.getTransaction().begin();
        List<Project> projectsByName = this.em
                .createQuery(new StringBuilder()
                                .append("FROM Project AS p ")
                                .append("WHERE p IN :last10Projects ")
                                .append("ORDER BY p.name ASC")
                                .toString()
                        , Project.class)
                .setParameter("last10Projects", last10Projects)
                .getResultList();

        this.em.getTransaction().commit();

        projectsByName.forEach(p -> System.out.printf("Project name: %s\n" +
                        " \tProject Description: %s\n" +
                        " \tProject Start Date:%s\n" +
                        " \tProject End Date: %s\n",
                p.getName(),
                p.getDescription(),
                p.getStartDate(),
                p.getEndDate()));

    }

    private void _10_getIncreaseSalaries() {
        this.em.getTransaction().begin();
        List<Employee> employees = this.em
                .createQuery(new StringBuilder()
                                .append("FROM Employee AS e ")
                                .append("WHERE e.department.name='Engineering' OR ")
                                .append("e.department.name='Tool Design' OR ")
                                .append("e.department.name='Marketing' OR ")
                                .append("e.department.name='Information Services'")
                                .toString()
                        , Employee.class)
                .getResultList();

        employees.forEach(e -> {
            BigDecimal increaseMultiplier = new BigDecimal(1.12);
            BigDecimal newSalary = e.getSalary().multiply(increaseMultiplier);
            e.setSalary(newSalary);
        });
        this.em.getTransaction().commit();
        employees.forEach(e -> System.out.printf("%s %s ($%.2f)\n",
                e.getFirstName(), e.getLastName(), e.getSalary()));
    }

}

