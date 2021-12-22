package renderer.shader.uniforms;

import org.lwjgl.opengl.GL20;

public class Uniform {

	private String variable;
	private int shaderLocation;
	
	public Uniform(String variable){
		this.variable = variable;
	}
	
	public void getUniformLocation(int programID){
		shaderLocation = GL20.glGetUniformLocation(programID, variable);
	}
	
	public int getLocation(){
		return shaderLocation;
	}
	
}
