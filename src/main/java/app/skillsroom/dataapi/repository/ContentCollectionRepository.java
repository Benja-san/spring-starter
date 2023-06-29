package app.skillsroom.dataapi.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import app.skillsroom.dataapi.model.Content;
import app.skillsroom.dataapi.model.Status;
import app.skillsroom.dataapi.model.Type;
import jakarta.annotation.PostConstruct;

// annotation to tell that this class is a repository
@Repository
public class ContentCollectionRepository {
    
    //Properties
    private final List<Content> content = new ArrayList<>();

    //Constructor
    public ContentCollectionRepository() {

    }

    //Methods
    //Find all
    public List<Content> findAll() {
        return content;
    }

    //Find by id
    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    //Save content
    public void save(Content content) {
        this.content.add(content);
    }

    //Post constructor
    
    // annotation to tell that this method will be executed after the construction of the bean
    @PostConstruct
    private void init() {
        Content content = new Content(
            1,
            "Pôle Nord Diagnostic",
            "Pôle Nord Diagnostic is a real estate diagnosis website where you can find the best price for your diagnosis in Haut-De-France",
            "https://www.polenorddiagnostic.fr/",
            "Pôle Nord Diagnostic is a real estate diagnosis website where you can find the best price for your diagnosis in Haut-De-France",
            "https://www.polenorddiagnostic.fr/wp-content/uploads/2021/03/logo-pole-nord-diagnostic.png",
            LocalDateTime.now(),
            LocalDateTime.now(),
            Status.PUBLISHED,
            Type.WORDPRESS
        );

        this.content.add(content);
    }
}
