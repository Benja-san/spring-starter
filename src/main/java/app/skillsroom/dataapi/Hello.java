package app.skillsroom.dataapi;

import org.springframework.stereotype.Component;

//If I want to pu this class available in the beanMessages: 
// I havce to put the Component annotation so it will be retrieved
@Component
public class Hello {
    public String getMessage() {
        return "Hello";
    }
}
