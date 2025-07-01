import dao.UserDAO;
import model.MenuOption;
import model.UserModel;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private final static UserDAO dao = new UserDAO();
    private final static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        while(true) {

            System.out.println("Bem vindo ao cadastro de usuário. selecione a operação desajada.");
            System.out.println(" 1 - Cadastrar");
            System.out.println(" 2 - Atualizar");
            System.out.println(" 3 - Excluir");
            System.out.println(" 4 - Buscar por identificador");
            System.out.println(" 5 - Listar");
            System.out.println(" 6 - Sair");
            System.out.print("Operação: ");
            var userInput = scanner.nextInt();

            var selectedOption = MenuOption.values()[userInput - 1];

            switch (selectedOption) {
                case SAVE -> {
                    var user = dao.save(requestToSave());
                    System.out.printf("Usuário cadastrado %s\n", user);
                }
                case UPDATE -> {
                    var user = dao.update(requestToUpdate());
                    System.out.printf("Usuário atualizado %s\n", user);
                }
                case DELETE -> {
                    dao.delete(requestId());
                    System.out.println("Usuário excluído");
                }
                case FIND_BY_ID -> {
                    var id = requestId();
                    var user = dao.findById(id);
                    System.out.printf("Usuário com id %s:\n", id);
                    System.out.println(user);
                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.println("Usuários cadastrados: ");
                    System.out.println("===================");
                    users.forEach(System.out::println);
                    System.out.println("========fim========");
                }
                case EXIT -> {
                    System.out.println("Encerrando sistema ...");
                    System.exit(0);
                }
            }

        }

    }

    private static UserModel requestToSave() {
        System.out.print("Informe o nome do usuário: ");
        var name = scanner.next();
        System.out.print("Informe o email do usuário: ");
        var email = scanner.next();
        System.out.print("Informe a data de nascimento do usuário (dd/MM/yyyy): ");
        var birthdayString = scanner.next();

        var formatter = DateTimeFormatter.ofPattern("(dd/MM/yyyy)");
        var birthday = OffsetDateTime.parse(birthdayString, formatter);

        return new UserModel(0L, name, email, birthday);
    }

    private static UserModel requestToUpdate() {
        var id = requestId();
        System.out.print("Informe o nome do usuário: ");
        var name = scanner.next();
        System.out.print("Informe o email do usuário: ");
        var email = scanner.next();
        System.out.print("Informe a data de nascimento do usuário (dd/MM/yyyy): ");
        var birthdayString = scanner.next();

        var formatter = DateTimeFormatter.ofPattern("(dd/MM/yyyy)");
        var birthday = OffsetDateTime.parse(birthdayString, formatter);

        return new UserModel(id, name, email, birthday);
    }

    private static long requestId() {
        System.out.print("Informe o identificador do usuário: ");
        return scanner.nextLong();
    }

}