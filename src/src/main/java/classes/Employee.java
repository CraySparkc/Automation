package classes;

class Employee {
    protected String name;
    protected int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public void work(){
        System.out.println("Работник по имени "+this.name+" выполняет работу за "+this.salary+" руб");
    }
}

