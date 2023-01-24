package renderer;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import entity.Camera;
import entity.Entity;
import entity.ModelComponent;
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
		GL11.glClearColor(0.125f, 0.125f, 0.5f, 1);
	}

	public void render(Entity entity, Camera camera) {
		ModelComponent comp = (ModelComponent) entity.getComponent("Model");
		if(comp == null) return;
		
		prepare();
		shader.useProgram();
		
		shader.getModelColor().loadVec3(0.5f, 1.0f, 0.5f);
		
		Matrix4f transformationMatrix = utils.createTransformationMatrix(entity.getTransform());
		shader.getTransformation().loadMatrix(transformationMatrix);
		
		Matrix4f viewMatrix = utils.createViewMatrix(camera);
		shader.getViewMatrix().loadMatrix(viewMatrix);
		
		Matrix4f projectionMatrix = utils.createProjectionMatrix(90, 0.1f, 1500f);
		shader.getProjectionMatrix().loadMatrix(projectionMatrix);
		
		comp.getVao().render();
		
		shader.stopProgram();
	}
	
}
