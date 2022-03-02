package main;

import entity.Camera;
import entity.Transform;
import models.Vao;
import renderer.SimpleRenderer;
import renderer.Window;
import utilities.Vector3f;

public class MainApp {

	public static void main(String[] args) {
		Window window = new Window();
		window.createWindow(1280, 720, "Tutorial Window");
		
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
		
		Camera camera = new Camera();
		camera.setPosition(new Vector3f(0,0,0));
		
		Transform transform = new Transform(new Vector3f(0.0f,0.0f,0.0f), new Vector3f(0,0,0), new Vector3f(1.0f,1.0f,1.0f));
		
		SimpleRenderer renderer = new SimpleRenderer();
		
		while(!window.shouldClose()) {					
			renderer.render(vao, transform, camera);
			window.updateWindow();
		}
		
		window.closeWindow();
	}

}