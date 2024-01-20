public class Employee {
    String fullName, position, email, phone;
    int salary, age;

    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void getInfo() {
        System.out.println(
                "Ф.И.О.: " + fullName +
                        "\nДолжность: " + position +
                        "\nEmail: " + email +
                        "\nТелефон: " + phone +
                        "\nSalary: " + salary +
                        "\nВозраст: " + age);
    }

    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Sokolov Sergey", "AQA", "sokolov@mailbox.com", "89231111111", 100000, 39);
        employeeArray[1] = new Employee("Fedorov Andrey", "QA", "fedorov@mailbox.com", "89232222222", 90000, 38);
        employeeArray[2] = new Employee("Skachkov Sergey", "Java developer", "skachkov@mailbox.com", "89233333333", 80000, 37);
        employeeArray[3] = new Employee("Ivanov Alexey", "Python developer", "ivanov@mailbox.com", "89234444444", 70000, 36);
        employeeArray[4] = new Employee("Petrov Evgeniy", "Android developer", "petrov@mailbox.com", "89235555555", 60000, 35);
        for (Employee employee : employeeArray) {
            employee.getInfo();
            System.out.println();
        }
    }
}
