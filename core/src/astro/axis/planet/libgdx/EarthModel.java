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


public class EarthModel extends ApplicationAdapter {
    private PerspectiveCamera camera; // Определение камеры
    private ModelBatch modelBatch; // Определение модели для отрисовки
    private ModelInstance earthInstance; // Экземпляр модели Земли
    private Model earthModel; // Модель Земли
    private Environment environment; // Окружение для модели
    private CameraInputController cameraController; // Контроллер ввода для камеры


    @Override
    public void create () {
        modelBatch = new ModelBatch(); // Инициализация модели для отрисовки

        // Инициализация камеры
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(0f, 0f, 3.5f); // Установка позиции камеры
        camera.lookAt(0,0,0); // Установка точки, на которую смотрит камера
        camera.near = 0.1f; // Установка ближней границы видимости камеры
        camera.far = 300f; // Установка дальней границы видимости камеры

        // Загрузка текстуры для модели Земли
        Texture texture = new Texture(Gdx.files.internal("Earth.jpg"));
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear); // Установка фильтрации текстуры

        // Создание материала с текстурой
        Material material = new Material(TextureAttribute.createDiffuse(texture));

        // Создание 3D модели Земли с применением текстуры
        ModelBuilder modelBuilder = new ModelBuilder();
        earthModel = modelBuilder.createSphere(2f, 2f, 2f, 20, 20, material,
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal | VertexAttributes.Usage.TextureCoordinates);

        earthInstance = new ModelInstance(earthModel); // Создание экземпляра модели Земли

        // Создание окружения для модели
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f)); // Установка окружающего освещения
        environment.add(new DirectionalLight().set(1f, 1f, 1f, -1f, -1f, -1f)); // Добавление направленного источника света

        // Инициализация контроллера ввода для камеры
        cameraController = new CameraInputController(camera);
        Gdx.input.setInputProcessor(cameraController); // Установка контроллера ввода
    }

    @Override
    public void render () {
        // Очистка экрана
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Установка области вывода
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        // Обновление контроллера ввода и камеры
        cameraController.update();
        camera.update();

        // Начало отрисовки модели
        modelBatch.begin(camera);
        modelBatch.render(earthInstance, environment); // Отрисовка экземпляра модели Земли с учетом окружения
        modelBatch.end(); // Завершение отрисовки модели
    }

    @Override
    public void dispose () {
        // Освобождение ресурсов
        modelBatch.dispose(); // Освобождение модели для отрисовки
        earthModel.dispose(); // Освобождение модели Земли
    }
}
