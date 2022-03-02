package renderer.shader.uniforms;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL20;

import utilities.Matrix4f;

public class UniformMatrix4f extends Uniform {

	private static FloatBuffer matrixBuffer = BufferUtils.createFloatBuffer(32);

	public UniformMatrix4f(String name) {
		super(name);
	}
	
	public void loadMatrix(Matrix4f matrix)	{
		matrix.store(matrixBuffer);
		GL20.glUniformMatrix4fv(super.getLocation(), false, matrixBuffer);
	}

	
}
