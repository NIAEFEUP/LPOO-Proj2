package element.def;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

/**
 * Finish line body definition.
 */
public class FinishLineDef extends GameElementDef {
    private final static BodyDef bodyDef = initBodyDef();
    private final static float HEIGHT = 1f;

    public FinishLineDef(float width) {
        super(bodyDef, initFixtureDef(width), width, HEIGHT);
    }

    /**
     * Creates a fixture definition.
     *
     * @param width finish line width's
     * @return
     */
    private static FixtureDef initFixtureDef(float width) {
        PolygonShape shape = new PolygonShape();

        shape.setAsBox(width /2 , HEIGHT / 2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.isSensor = true;
        fixtureDef.shape = shape;

        return fixtureDef;
    }

    /**
     * Creates a body definition.
     *
     * @return Created body definition.
     */
    private static BodyDef initBodyDef() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.allowSleep = true;
        return bodyDef;
    }
}
