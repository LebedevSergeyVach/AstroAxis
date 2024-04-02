package astro.axis.planet.libgdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class MercuryModel extends ApplicationAdapter {
    private Texture earthTexture;
    private PerspectiveCamera camera;
    private ModelBatch modelBatch;
    private ModelInstance earthInstance;
    private Model earthModel;
    private Environment environment;
    private CameraInputController cameraController;

    @Override
    public void create () {
        modelBatch = new ModelBatch();

        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(0f, 0f, 3.5f);
        camera.lookAt(0,0,0);
        camera.near = 0.1f;
        camera.far = 300f;


        // Загрузка текстуры
        Texture texture = new Texture(Gdx.files.internal("Mercury.jpg"));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        // Создание материала с текстурой
        Material material = new Material(TextureAttribute.createDiffuse(texture));

        // Создание 3D модели с применением текстуры
        ModelBuilder modelBuilder = new ModelBuilder();
        earthModel = modelBuilder.createSphere(2f, 2f, 2f, 20, 20, material,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates);

        earthInstance = new ModelInstance(earthModel);

        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(1f, 1f, 1f, -1f, -1f, -1f));

        cameraController = new CameraInputController(camera);
        Gdx.input.setInputProcessor(cameraController);
    }

    @Override
    public void render () {
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        cameraController.update();
        camera.update();

        modelBatch.begin(camera);
        modelBatch.render(earthInstance, environment);
        modelBatch.end();
    }

    @Override
    public void dispose () {
        modelBatch.dispose();
        earthModel.dispose();
    }
}
