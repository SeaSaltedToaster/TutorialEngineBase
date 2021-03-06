package renderer;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import entity.Camera;
import entity.Transform;
import models.Vao;
import utilities.Matrix4f;
import utilities.MatrixUtils;

public class SimpleRenderer {
	
	//Shaders
	private SimpleShader shader;
	
	//Matrices
	private MatrixUtils utils;
	
	public SimpleRenderer() {
		this.shader = new SimpleShader();
		this.utils = new MatrixUtils();
	}
	
	private void prepare() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glClearColor(1.0f, 0.0f, 0.0f, 1);
	}

	public void render(Vao vao, Transform transform, Camera camera) {
		prepare();
		shader.useProgram();
		shader.getModelColor().loadVec3(0.5f, (float) Math.abs(Math.sin(GLFW.glfwGetTime())), 0.5f);
		Matrix4f transformationMatrix = utils.createTransformationMatrix(transform.getPosition(), transform.getRotation().x, transform.getRotation().x, transform.getRotation().x, transform.getScale());
		shader.getTransformation().loadMatrix(transformationMatrix);
		Matrix4f viewMatrix = utils.createViewMatrix(camera);
		shader.getViewMatrix().loadMatrix(viewMatrix);
		vao.render();
		shader.stopProgram();
	}
	
}
