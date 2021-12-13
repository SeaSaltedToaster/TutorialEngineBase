package models;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL15;

public class Vbo {
	
	private final int vboId;
	private final int type;
	
	public Vbo(int type){
		this.vboId = GL15.glGenBuffers();
		this.type = type;
	}
	
	public void bind() {
		GL15.glBindBuffer(type, vboId);
	}
	
	public void unbind(){
		GL15.glBindBuffer(type, 0);
	}
	
	public void storeFloatData(float[] data) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		storeFloatData(buffer);
	}

	public void storeIntData(int[] data) {
		IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
		buffer.put(data);
		buffer.flip();
		storeIntData(buffer);
	}
	
	public void storeIntData(IntBuffer data) {
		GL15.glBufferData(type, data, GL15.GL_STATIC_DRAW);
	}
	
	public void storeFloatData(FloatBuffer data) {
		GL15.glBufferData(type, data, GL15.GL_STATIC_DRAW);
	}

	public void destroy() {
		GL15.glDeleteBuffers(vboId);
	}

	public int getVboId() {
		return vboId;
	}

	public int getType() {
		return type;
	}

}
