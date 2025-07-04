package dao;

import exceptions.EmptyStorageException;
import exceptions.UserNotFoundException;
import model.UserModel;

import java.util.ArrayList;
import java.util.List;

// CRUD in memory
public class UserDAO {

    private long nextId = 1L;

    private final List<UserModel> models = new ArrayList<>();

    // CREATE
    public UserModel save(final UserModel model) {
        model.setId(nextId++);  // Usa o valor e na proxima linha incrementa
        models.add(model);
        return model;
    }

    // READ
    public UserModel findById(final long id) {
        verifyStorage();
        var errorMessage = String.format("Não existe usuário com o id %s cadastrado", id);

        return models.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow( () -> new UserNotFoundException(errorMessage));
    }

    // READ
    public List<UserModel> findAll() {
        List<UserModel> result;

        try {
            verifyStorage();
            result = models;
        } catch (EmptyStorageException ex) {
            ex.printStackTrace();
            result = new ArrayList<>();
        }

        return result;
    }

    // UPDATE
    public UserModel update(final UserModel model) {
        var toUpdate = findById(model.getId());

        models.remove(toUpdate);
        models.add(toUpdate);
        return model;
    }

    // DELETE
    public void delete(final long id) {
        var toDelete = findById(id);
        models.remove(toDelete);
    }

    private void verifyStorage() {
        if(models.isEmpty()) throw new EmptyStorageException("O armazenamento está vazio");
    }

}
