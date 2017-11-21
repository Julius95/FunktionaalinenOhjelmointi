/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Simo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AbstractShapeFactory factory = new ShapeFactory();

        Shape shape1 = factory.getShape("circle");
        Shape shape2 = factory.getShape("rectangle");

        shape1.draw();
        shape2.draw();
    }

}
