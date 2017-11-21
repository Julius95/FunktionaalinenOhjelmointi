/**
 *
 * @author Simo
 */
public class ShapeFactory3D extends AbstractShapeFactory {

    public ShapeFactory3D (){
        map.put("CIRCLE", Circle3D::new);
        map.put("RECTANGLE", Rectangle3D::new);
    }

}
