package renderer;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

public class Window {
	
	public long windowID;
	
	public void createWindow(int width, int height, String title) {
		boolean initState = GLFW.glfwInit();
		
		if(initState == false) {
			throw new IllegalStateException("Could not create GLFW");
		}
		
		windowID = GLFW.glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);
		
		if(windowID == MemoryUtil.NULL) {
			throw new IllegalStateException("Cant make window :(");
		}
		
		GLFW.glfwMakeContextCurrent(windowID);
		GLFW.glfwSwapInterval(1);
		GLFW.glfwShowWindow(windowID);
		GL.createCapabilities();
	}
	
	public void updateWindow() {
		GLFW.glfwSwapBuffers(windowID);
		GLFW.glfwPollEvents();
		GLFW.glfwSwapInterval(1);
	}
	
	public void closeWindow() {
		GLFW.glfwDestroyWindow(windowID);
		GLFW.glfwTerminate();
	}
	
	public boolean shouldClose() {
		return GLFW.glfwWindowShouldClose(windowID);
	}

}

