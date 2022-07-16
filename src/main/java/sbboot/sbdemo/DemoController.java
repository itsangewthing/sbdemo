package sbboot.sbdemo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class DemoController {

    private Map<String, Photo> db = new HashMap<>() {{
        put("1", new Photo("1","hello.jpg"));
    }};

//    Create new photo
//    private List<Photo> db = List.of(new Photo("1", "Hello.jpg"));

    public DemoController(Map<String, Photo> db) {
        this.db = db;
    }

    //    testing with Hello World
    @GetMapping("/photos")
    public Collection<Photo> get(){
        return db.values();
    }

    // Photos to return list of photos, if there's curly braces, program would know where to get the list of photos
    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable String id) {

        Photo photo = db.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    //TO DELETE PHOTO
    @DeleteMapping("/photos")
    public void delete(String id){
        Photo photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
