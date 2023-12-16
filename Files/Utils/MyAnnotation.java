import java.lang.reflect.*;

public class MyAnnotation extends Component {
    
    public void start() {
        execute();
    }
    
    public void execute() {
        List<SpatialObject> allObjects = WorldController.getObjectList();
        
        for(SpatialObject object: allObjects) {
            for(int i = 0; i < object.componentCount(); i++) {
                Component component = object.componentAt(i);
                Field[] fields = component.getClass().getDeclaredFields();
                
                for(Field field: fields) {
                    java.lang.annotation.Annotation annotation = field.getAnnotation(FindInChild.class);
                    
                    if(annotation != null) {
                        try {
                            field.setAccessible(true);
                            String childName = ((FindInChild) annotation).value();
                            
                            String[] childs = childName.split("/");
                            
                            SpatialObject child;
                            
                            if(childs.length > 1) {
                                child = object;
                                
                                for(String currentChildName: childs) {
                                    child = child.findChildObject(currentChildName);
                                }
                            }
                            
                            else {
                                child = object.findChildObject(childName);
                            }
                            
                            field.set(component, child);
                        }
                        
                        catch(Exception e) {
                            Console.log(e);
                        }
                    }
                }
            }
        }
    }
    
    public String getComponentMenu() {
        return "Annotation";
    }
}
