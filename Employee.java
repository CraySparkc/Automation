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

class Manager extends Employee {
    final String position;
    public Manager(String name, int salary) {
        super(name, salary);
        this.position = "менеджер";
    }
    @Override
    public void work(){
        System.out.println("Работник-"+this.position+" по имени "+this.name+" выполняет работу за "+this.salary+" руб");
    }
}
class Developer extends Employee {
    final String position;
    public Developer(String name, int salary) {
        super(name, salary);
        this.position = "разработчик";
    }
    @Override
    public void work(){
        System.out.println("Работник-"+this.position+" по имени "+this.name+" выполняет работу за "+this.salary+" руб");
    }
}
