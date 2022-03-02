package renderer;

import renderer.shader.Shader;
import renderer.shader.uniforms.UniformMatrix4f;
import renderer.shader.uniforms.UniformVec3;

public class SimpleShader extends Shader {
	
	private static final String vertexShader = "/shaders/vert.glsl";
	private static final String fragmentShader = "/shaders/frag.glsl";
	
	protected UniformVec3 modelColor = new UniformVec3("color");
	protected UniformMatrix4f transformation = new UniformMatrix4f("transformationMatrix");
	protected UniformMatrix4f viewMatrix = new UniformMatrix4f("viewMatrix");

	public SimpleShader() {
		super(vertexShader, fragmentShader);
		super.locateUniform(modelColor);
		super.locateUniform(transformation);
		super.locateUniform(viewMatrix);
	}
	
	public UniformMatrix4f getTransformation() {
		return transformation;
	}
	
	public UniformMatrix4f getViewMatrix() {
		return viewMatrix;
	}

	public UniformVec3 getModelColor() {
		return modelColor;
	}

}
