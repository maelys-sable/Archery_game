package fr.ensicaen.ecole.archery;
import java.awt.geom.Point2D;
public interface Projectile {
    Point2D.Double get_position(double depth);
}
