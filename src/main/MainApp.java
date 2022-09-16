package main;

import org.lwjgl.glfw.GLFW;

import entity.Camera;
import entity.Entity;
import entity.ModelComponent;
import entity.Transform;
import models.Vao;
import renderer.SimpleRenderer;
import renderer.Window;
import utilities.Vector3f;

public class MainApp {

	public static void main(String[] args) {
		//Create window
		Window window = new Window();
		window.createWindow(1280, 720, "Tutorial Base Window");
		
		//Create Model
		float[] vertices = {
			0, 0.75f, 0,
			-0.75f, -0.5f, 0,
			0.75f, -0.5f, 0,
		};
		int[] indices = {
			0,1,2
		};
		
		Vao vao = new Vao();
		vao.bind();
		vao.createFloatAttribute(0, vertices, 3);
		vao.createIndexBuffer(indices);
		vao.setIndexCount(indices.length);
		vao.unbind();
		
		//Camera and rendering objects
		Camera camera = new Camera();
		camera.setPosition(new Vector3f(0.0f,0.0f,0.0f));
		
		SimpleRenderer renderer = new SimpleRenderer();
		
		//Entities
		Transform transform = new Transform(new Vector3f(0.0f,0.0f,-2.0f), new Vector3f(0,0,0), new Vector3f(1.0f,1.0f,1.0f));
		Entity entity = new Entity();
		entity.setTransform(transform);
		entity.addComponent(new ModelComponent(vao));
		
		while(!window.shouldClose()) {	
			transform.getRotation().y += 1f;
			transform.getScale().setY((float) Math.sin(GLFW.glfwGetTime()) * 2);
			
			camera.update(window.windowID);
			renderer.render(entity, camera);
			window.updateWindow();
		}
		
		window.closeWindow();
	}

}