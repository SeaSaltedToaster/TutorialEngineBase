package main;

import models.Vao;
import renderer.SimpleRenderer;
import renderer.Window;

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
		
		SimpleRenderer renderer = new SimpleRenderer();
		
		while(!window.shouldClose()) {
			renderer.render(vao);
			window.updateWindow();
		}
		
		window.closeWindow();
	}

}