package renderer;

import org.lwjgl.opengl.GL11;

import models.Vao;

public class SimpleRenderer {
	
	private SimpleShader shader;
	
	public SimpleRenderer() {
		this.shader = new SimpleShader();
	}
	
	private void prepare() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glClearColor(1.0f, 0.0f, 0.0f, 1);
	}

	public void render(Vao vao) {
		prepare();
		shader.useProgram();
		vao.render();
		shader.stopProgram();
	}
	
}
