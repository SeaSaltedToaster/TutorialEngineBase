package renderer;

import org.lwjgl.glfw.GLFW;
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
		shader.getModelColor().loadVec3(0.5f, (float) Math.abs(Math.sin(GLFW.glfwGetTime())), 0.5f);
		shader.getTranslation().loadVec2((float) Math.sin(GLFW.glfwGetTime()) / 2, (float) Math.sin(GLFW.glfwGetTime() - 1f) / 2);
		vao.render();
		shader.stopProgram();
	}
	
}
