package app.skillsroom.dataapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.skillsroom.dataapi.model.Content;
import app.skillsroom.dataapi.repository.ContentCollectionRepository;

// annotation to tell that this class is a controller
@RestController
// annotation to tell that this controller will be available at the following address
@RequestMapping ("/api/content")
public class ContentController {

    // create this property to inject and use repository in the controller
    //Just right click on this property and add a constructor mate!
    private final ContentCollectionRepository repository;
    
    //Dependency injection of the repository also called Inversion of control, we are not responsible anymore of injecting repository injection, spring will do
    //Autowired bean!
    public ContentController(ContentCollectionRepository repository) {
        // Old way contentCollectionRepository = new ContentCollectionRepository();
        // New way
        this.repository = repository;
    }

    //Methods
    //Find all
    //Get all the content
    // annotation to tell that this method will be available at the following address
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    //Add methods of the CRUD or some filtered special methods called by the content route

    //Find one by id:
    //Get one content by id
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    //Create a content
    //Also we need to specify that the content will be sent by a request body @RequestBody annotation usefull for that
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content) {
        repository.save(content);
    }

}
