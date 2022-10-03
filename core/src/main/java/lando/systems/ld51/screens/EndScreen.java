package lando.systems.ld51.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;

public class EndScreen extends BaseScreen {

    private boolean exitingScreen = false;

    @Override
    public void update(float delta) {
        super.update(delta);

        // TODO possibly make it in a button
        if (!exitingScreen && Gdx.input.justTouched()){
            exitingScreen = true;
            game.getScreenManager().pushScreen("credit", "blend");
        }
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.SKY);

        OrthographicCamera camera = windowCamera;
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        {
            assets.layout.setText(assets.largeFont, "Copy needed here", Color.WHITE, camera.viewportWidth, Align.center, false);
            assets.largeFont.draw(batch, assets.layout, 0, camera.viewportHeight / 2f + assets.layout.height);
        }
        batch.end();
    }
}
