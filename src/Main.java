import dao.UserDAO;
import exceptions.EmptyStorageException;
import exceptions.UserNotFoundException;
import exceptions.ValidatorException;
import model.MenuOption;
import model.UserModel;
import validator.UserValidator;

import java.time.LocalDate;
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
                    try {
                        var user = dao.save(requestToSave());
                        System.out.printf("Usuário cadastrado %s\n", user);
                    } catch (ValidatorException ex) {
                        System.out.println(ex.getMessage());
                    }

                }
                case UPDATE -> {
                    try {
                        var user = dao.update(requestToUpdate());
                        System.out.printf("Usuário atualizado %s\n", user);
                    } catch (UserNotFoundException | EmptyStorageException | ValidatorException ex) {
                        System.out.println(ex.getMessage());
                    } finally {
                        System.out.println("===================");
                    }

                }
                case DELETE -> {
                    try {
                        dao.delete(requestId());
                        System.out.println("Usuário excluído");
                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    } finally {
                        System.out.println("===================");
                    }

                }
                case FIND_BY_ID -> {

                    try {
                        var id = requestId();
                        var user = dao.findById(id);
                        System.out.printf("Usuário com id %s:\n", id);
                        System.out.println(user);
                    } catch (UserNotFoundException | EmptyStorageException ex) {
                        System.out.println(ex.getMessage());
                    }
                    finally {
                        System.out.println("===================");
                    }

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

    private static UserModel requestToSave() throws ValidatorException {
        System.out.print("Informe o nome do usuário: ");
        var name = scanner.next();
        System.out.print("Informe o email do usuário: ");
        var email = scanner.next();
        System.out.print("Informe a data de nascimento do usuário (dd/MM/yyyy): ");
        var birthdayString = scanner.next();

        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);

        return validateInputs(0L, name, email, birthday);
    }

    private static UserModel requestToUpdate() throws ValidatorException {
        var id = requestId();
        System.out.print("Informe o nome do usuário: ");
        var name = scanner.next();
        System.out.print("Informe o email do usuário: ");
        var email = scanner.next();
        System.out.print("Informe a data de nascimento do usuário (dd/MM/yyyy): ");
        var birthdayString = scanner.next();

        var formatter = DateTimeFormatter.ofPattern("(dd/MM/yyyy)");
        var birthday = LocalDate.parse(birthdayString, formatter);
        return validateInputs(0L, name, email, birthday);
    }

    private static long requestId() {
        System.out.print("Informe o identificador do usuário: ");
        return scanner.nextLong();
    }

    private static UserModel validateInputs(final long id, final String name,
                                            final String email, final LocalDate birthday)
                                            throws ValidatorException {
        var user = new UserModel(0L, name, email, birthday);
        UserValidator.verifyModel(user);
        return user;
    }

}