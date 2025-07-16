package challenges.polymorphism.challenge2.model;

public abstract class Employee {

    private String name;
    private String email;
    private String password;
    private boolean isLogged;
    private final boolean isAdministrador;


    public Employee(String name, String email, String password, boolean isAdministrador) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdministrador = isAdministrador;
        this.isLogged = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdministrador() {
        return isAdministrador;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void doLogin() {
        if(isLogged) {
            System.out.println("Você já está logado...");
        } else {
            System.out.println("Fazendo Login...");
            isLogged = true;
        }
    }

    public void doLogoff() {
        if(isLogged) {
            System.out.println("Fazendo Logoff...");
            isLogged = false;
        } else {
            System.out.println("Vicê não está logado...");
        }
    }


}
