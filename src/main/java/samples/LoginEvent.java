package samples;

import java.util.Map;


import org.dwcj.component.event.Event;
import org.dwcj.component.AbstractComponent;

public class LoginEvent extends Event<AbstractComponent>{

    // public LoginEvent(AbstractComponent component, Map<String,Object> myMap) {
    //     super(component, myMap);
    // }
    public LoginEvent(AbstractComponent component, Map<String,Object> payload) {
        super(component, payload);
    }
    
}
